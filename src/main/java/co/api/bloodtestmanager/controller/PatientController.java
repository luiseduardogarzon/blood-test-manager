package co.api.bloodtestmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.api.bloodtestmanager.entity.Patient;
import co.api.bloodtestmanager.entity.PatientResponse;
import co.api.bloodtestmanager.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("patient")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient) {
		return new ResponseEntity<Patient>(this.patientService.savePatient(patient), HttpStatus.CREATED);
	}

	@GetMapping("/patient/{document}")
	public ResponseEntity<PatientResponse> getPatigetPatientRisksList(@PathVariable("document") Long document) {
		return new ResponseEntity<PatientResponse>(this.patientService.getPatientRiskByDocument(document),
				HttpStatus.OK);
	}
}
