package co.api.bloodtestmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.api.bloodtestmanager.entity.Patient;
import co.api.bloodtestmanager.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping("patient")
	public Patient savePatient(@RequestBody Patient patient ) {
		return this.patientRepository.save(patient);
	}
}
