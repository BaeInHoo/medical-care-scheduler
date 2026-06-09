package com.example.medicalcarescheduler.entity;

import com.example.medicalcarescheduler.entity.enums.AppointmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "hospital_appointments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalAppointment extends BaseTimeEntity {

	public HospitalAppointment(User user) {
		this.user = user;
		this.status = AppointmentStatus.SCHEDULED;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private String hospitalName;

	private String department;

	private String doctorName;

	@Column(nullable = false)
	private LocalDate appointmentDate;

	@Column(nullable = false)
	private LocalTime appointmentTime;

	private String purpose;

	@Column(columnDefinition = "TEXT")
	private String memo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private AppointmentStatus status = AppointmentStatus.SCHEDULED;
}
