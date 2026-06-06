package com.example.medicalcarescheduler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "medicines")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Medicine extends BaseTimeEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private String medicineName;

	@Column(nullable = false)
	private LocalDate startDate;

	@Column(nullable = false)
	private LocalDate endDate;

	private String dosage;

	private String instruction;

	@Column(columnDefinition = "TEXT")
	private String memo;

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "medicine")
	private List<MedicineTime> medicineTimes = new ArrayList<>();

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "medicine")
	private List<MedicineLog> medicineLogs = new ArrayList<>();
}
