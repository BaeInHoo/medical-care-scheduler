package com.example.medicalcarescheduler.controller;

import com.example.medicalcarescheduler.service.MedicalCareService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MedicalCareController {

	private final MedicalCareService medicalCareService;
}
