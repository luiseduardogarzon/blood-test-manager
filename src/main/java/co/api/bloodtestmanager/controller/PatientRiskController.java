package co.api.bloodtestmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.api.bloodtestmanager.entity.PatientRisk;
import co.api.bloodtestmanager.service.PatientRiskService;

@RestController
public class PatientRiskController {

	@Autowired
	private PatientRiskService patientRiskService;

	@PostMapping("/patientrisk")
	public ResponseEntity<PatientRisk> savePatientRisk(@Valid @RequestBody PatientRisk patientRisk) {
		return new ResponseEntity<PatientRisk>(this.patientRiskService.savePatientRisk(patientRisk),
				HttpStatus.CREATED);
	}
}
