package co.api.bloodtestmanager.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.api.bloodtestmanager.entity.Patient;
import co.api.bloodtestmanager.entity.PatientResponse;
import co.api.bloodtestmanager.entity.PatientRisk;
import co.api.bloodtestmanager.entity.PatientRiskResponse;
import co.api.bloodtestmanager.entity.Risk;
import co.api.bloodtestmanager.repository.PatientRepository;
import co.api.bloodtestmanager.repository.RiskRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private RiskRepository riskRepository;

	@Override
	public Patient savePatient(Patient patient) {
		return this.patientRepository.save(patient);
	}

	@Override
	public PatientResponse getPatientRiskByDocument(Long document) {
		Patient patient = this.patientRepository.findByDocument(document).get();
		PatientResponse patientResponse = new PatientResponse();
		patientResponse.setId(patient.getId());
		patientResponse.setDocument(patient.getDocument());
		patientResponse.setName(patient.getName());
		patientResponse.setLastName(patient.getLastName());
		patientResponse.setEmail(patient.getEmail());
		patientResponse.setAge(patient.getAge());

		patientResponse.setPatientRiskList(new ArrayList<>());

		for (PatientRisk patientRisk : patient.getPatientRiskList()) {
			PatientRiskResponse patientRiskResponse = new PatientRiskResponse();
			patientRiskResponse.setSugarPercentage(patientRisk.getSugarPercentage());
			patientRiskResponse.setFatPercentage(patientRisk.getFatPercentage());
			patientRiskResponse.setOxygenPercentage(patientRisk.getOxygenPercentage());

			if (null != patientRisk.getRiskId()) {
				Optional<Risk> risk = this.riskRepository.findById(patientRisk.getRiskId());
				patientRiskResponse.setRiskLevel(risk.get().getRiskName());
			}

			patientResponse.getPatientRiskList().add(patientRiskResponse);

		}
		return patientResponse;
	}
}
