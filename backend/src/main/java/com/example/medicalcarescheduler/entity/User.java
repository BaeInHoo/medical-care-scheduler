package com.example.medicalcarescheduler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	private String phone;

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "user")
	private List<HospitalAppointment> hospitalAppointments = new ArrayList<>();

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "user")
	private List<Medicine> medicines = new ArrayList<>();

	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "user")
	private List<MedicineLog> medicineLogs = new ArrayList<>();
}
