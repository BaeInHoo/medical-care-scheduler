package com.example.medicalcarescheduler.service;

import com.example.medicalcarescheduler.dto.AppointmentRequest;
import com.example.medicalcarescheduler.dto.AppointmentResponse;
import com.example.medicalcarescheduler.entity.HospitalAppointment;
import com.example.medicalcarescheduler.entity.User;
import com.example.medicalcarescheduler.entity.enums.AppointmentStatus;
import com.example.medicalcarescheduler.exception.ResourceNotFoundException;
import com.example.medicalcarescheduler.repository.HospitalAppointmentRepository;
import com.example.medicalcarescheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AppointmentService {

	private final HospitalAppointmentRepository appointmentRepository;
	private final UserRepository userRepository;

	public List<AppointmentResponse> getAppointments(Long userId) {
		validateUserExists(userId);
		return appointmentRepository.findAllByUser_Id(userId).stream()
			.map(AppointmentResponse::from)
			.toList();
	}

	public AppointmentResponse getAppointment(Long userId, Long appointmentId) {
		return AppointmentResponse.from(findAppointment(userId, appointmentId));
	}

	@Transactional
	public AppointmentResponse createAppointment(Long userId, AppointmentRequest request) {
		User user = findUser(userId);
		HospitalAppointment appointment = new HospitalAppointment(user);

		updateAppointment(appointment, request);
		appointment.setStatus(AppointmentStatus.SCHEDULED);

		return AppointmentResponse.from(appointmentRepository.save(appointment));
	}

	@Transactional
	public AppointmentResponse updateAppointment(Long userId, Long appointmentId, AppointmentRequest request) {
		HospitalAppointment appointment = findAppointment(userId, appointmentId);
		updateAppointment(appointment, request);
		return AppointmentResponse.from(appointmentRepository.saveAndFlush(appointment));
	}

	@Transactional
	public AppointmentResponse cancelAppointment(Long userId, Long appointmentId) {
		HospitalAppointment appointment = findAppointment(userId, appointmentId);
		appointment.setStatus(AppointmentStatus.CANCELED);
		return AppointmentResponse.from(appointmentRepository.saveAndFlush(appointment));
	}

	@Transactional
	public AppointmentResponse completeAppointment(Long userId, Long appointmentId) {
		HospitalAppointment appointment = findAppointment(userId, appointmentId);
		appointment.setStatus(AppointmentStatus.COMPLETED);
		return AppointmentResponse.from(appointmentRepository.saveAndFlush(appointment));
	}

	private User findUser(Long userId) {
		return userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
	}

	private void validateUserExists(Long userId) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found: " + userId);
		}
	}

	private HospitalAppointment findAppointment(Long userId, Long appointmentId) {
		return appointmentRepository.findByIdAndUser_Id(appointmentId, userId)
			.orElseThrow(() -> new ResourceNotFoundException("Appointment not found: " + appointmentId));
	}

	private void updateAppointment(HospitalAppointment appointment, AppointmentRequest request) {
		appointment.setHospitalName(request.hospitalName());
		appointment.setDepartment(request.department());
		appointment.setDoctorName(request.doctorName());
		appointment.setAppointmentDate(request.appointmentDate());
		appointment.setAppointmentTime(request.appointmentTime());
		appointment.setPurpose(request.purpose());
		appointment.setMemo(request.memo());
	}
}
