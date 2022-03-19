package co.api.bloodtestmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.api.bloodtestmanager.constant.EComponent;
import co.api.bloodtestmanager.entity.Disease;
import co.api.bloodtestmanager.entity.Patient;
import co.api.bloodtestmanager.entity.PatientRisk;
import co.api.bloodtestmanager.entity.Risk;
import co.api.bloodtestmanager.entity.RiskLevel;
import co.api.bloodtestmanager.repository.PatientRepository;
import co.api.bloodtestmanager.repository.PatientRiskRepository;

@Service
public class PatientRiskServiceImpl implements PatientRiskService {

	@Autowired
	private PatientRiskRepository patientRiskRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DiseaseService diseaseService;

	@Override
	public PatientRisk savePatientRisk(PatientRisk patientRisk) {
		Disease disease = this.diseaseService.getDiseaseById(patientRisk.getDiseaseId());

		Optional<Patient> patient = this.patientRepository.findByDocument(patientRisk.getDocument());
		patientRisk.setPatient(patient.get());

		this.calculateRisk(disease, patientRisk);
		return this.patientRiskRepository.save(patientRisk);
	}

	private void calculateRisk(Disease disease, PatientRisk patientRisk) {
		for (Risk risk : disease.getRiskList()) {
			Boolean isRisk = Boolean.TRUE;
			for (RiskLevel riskLevel : risk.getRiskLevelList()) {
				if (!this.isPatientRisk(patientRisk, riskLevel)) {
					isRisk = Boolean.FALSE;
					break;
				}
			}
			if (isRisk) {
				patientRisk.setRiskId(risk.getId());
				break;
			}
		}
	}

	private Boolean isPatientRisk(PatientRisk patientRisk, RiskLevel riskLevel) {
		Double componentPercentage = 0D;
		switch (EComponent.getEComponent(riskLevel.getName())) {
		case SUGAR:
			componentPercentage = patientRisk.getSugarPercentage();
			break;
		case OXYGEN:
			componentPercentage = patientRisk.getOxygenPercentage();
			break;
		case FAT:
			componentPercentage = patientRisk.getFatPercentage();
		}
		return this.isValuesBetween(componentPercentage, riskLevel.getLowValue(), riskLevel.getHighValue());
	}

	private Boolean isValuesBetween(Double value, Double lowValue, Double highValue) {
		return value >= lowValue && value <= highValue;
	}
}
