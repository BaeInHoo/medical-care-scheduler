package com.example.medicalcarescheduler.dto;

import com.example.medicalcarescheduler.entity.HospitalAppointment;
import com.example.medicalcarescheduler.entity.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AppointmentResponse(
	Long id,
	Long userId,
	String hospitalName,
	String department,
	String doctorName,
	LocalDate appointmentDate,
	LocalTime appointmentTime,
	String purpose,
	String memo,
	AppointmentStatus status,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {

	public static AppointmentResponse from(HospitalAppointment appointment) {
		return new AppointmentResponse(
			appointment.getId(),
			appointment.getUser().getId(),
			appointment.getHospitalName(),
			appointment.getDepartment(),
			appointment.getDoctorName(),
			appointment.getAppointmentDate(),
			appointment.getAppointmentTime(),
			appointment.getPurpose(),
			appointment.getMemo(),
			appointment.getStatus(),
			appointment.getCreatedAt(),
			appointment.getUpdatedAt()
		);
	}
}
