package com.example.medicalcarescheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequest(
	@NotBlank String hospitalName,
	String department,
	String doctorName,
	@NotNull LocalDate appointmentDate,
	@NotNull LocalTime appointmentTime,
	String purpose,
	String memo
) {
}
