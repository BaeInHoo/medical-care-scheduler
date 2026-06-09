package com.example.medicalcarescheduler.repository;

import com.example.medicalcarescheduler.entity.MedicineLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicineLogRepository extends JpaRepository<MedicineLog, Long> {

	List<MedicineLog> findAllByUser_IdAndScheduledDate(Long userId, LocalDate scheduledDate);
}
