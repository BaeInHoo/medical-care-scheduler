package com.example.medicalcarescheduler.entity;

import com.example.medicalcarescheduler.entity.enums.MedicineLogStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "medicine_logs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MedicineLog extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "medicine_id", nullable = false)
	private Medicine medicine;

	@Column(nullable = false)
	private LocalDate scheduledDate;

	@Column(nullable = false)
	private LocalTime scheduledTime;

	private LocalDateTime actualTakenTime;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private MedicineLogStatus status = MedicineLogStatus.PENDING;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}
}
