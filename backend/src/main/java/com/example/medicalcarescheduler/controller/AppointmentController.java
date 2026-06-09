package com.example.medicalcarescheduler.controller;

import com.example.medicalcarescheduler.dto.AppointmentRequest;
import com.example.medicalcarescheduler.dto.AppointmentResponse;
import com.example.medicalcarescheduler.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

	private final AppointmentService appointmentService;

	@GetMapping
	public List<AppointmentResponse> getAppointments(@RequestParam Long userId) {
		return appointmentService.getAppointments(userId);
	}

	@GetMapping("/{id}")
	public AppointmentResponse getAppointment(@PathVariable Long id, @RequestParam Long userId) {
		return appointmentService.getAppointment(userId, id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AppointmentResponse createAppointment(
		@RequestParam Long userId,
		@Valid @RequestBody AppointmentRequest request
	) {
		return appointmentService.createAppointment(userId, request);
	}

	@PutMapping("/{id}")
	public AppointmentResponse updateAppointment(
		@PathVariable Long id,
		@RequestParam Long userId,
		@Valid @RequestBody AppointmentRequest request
	) {
		return appointmentService.updateAppointment(userId, id, request);
	}

	@PatchMapping("/{id}/cancel")
	public AppointmentResponse cancelAppointment(@PathVariable Long id, @RequestParam Long userId) {
		return appointmentService.cancelAppointment(userId, id);
	}

	@PatchMapping("/{id}/complete")
	public AppointmentResponse completeAppointment(@PathVariable Long id, @RequestParam Long userId) {
		return appointmentService.completeAppointment(userId, id);
	}
}
