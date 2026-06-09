package com.example.medicalcarescheduler.repository;

import com.example.medicalcarescheduler.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	List<Medicine> findAllByUser_Id(Long userId);
}
