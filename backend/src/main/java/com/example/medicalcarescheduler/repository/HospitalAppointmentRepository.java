package com.example.medicalcarescheduler.repository;

import com.example.medicalcarescheduler.entity.HospitalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalAppointmentRepository extends JpaRepository<HospitalAppointment, Long> {

	List<HospitalAppointment> findAllByUser_Id(Long userId);
}
