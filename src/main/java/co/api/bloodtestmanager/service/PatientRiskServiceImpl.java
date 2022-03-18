package co.api.bloodtestmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.api.bloodtestmanager.entity.PatientRisk;
import co.api.bloodtestmanager.repository.PatientRiskRepository;

@Service
public class PatientRiskServiceImpl implements PatientRiskService {

	@Autowired
	private PatientRiskRepository patientRiskRepository;

	@Override
	public PatientRisk savePatientRisk(PatientRisk patientRisk) {
		return this.patientRiskRepository.save(patientRisk);
	}
}
