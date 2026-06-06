package com.example.medicalcarescheduler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "medicine_times")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MedicineTime extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "medicine_id", nullable = false)
	private Medicine medicine;

	@Column(nullable = false)
	private LocalTime takeTime;
}
