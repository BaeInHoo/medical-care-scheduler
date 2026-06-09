package com.example.medicalcarescheduler.repository;

import com.example.medicalcarescheduler.entity.MedicineTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineTimeRepository extends JpaRepository<MedicineTime, Long> {
}
