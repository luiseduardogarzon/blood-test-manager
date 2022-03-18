package co.api.bloodtestmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		for (Risk risk : disease.getRiskList()) {

			Boolean isSugar = Boolean.FALSE;
			Boolean isFat = Boolean.FALSE;
			Boolean isOxygen = Boolean.FALSE;

			for (RiskLevel riskLevel : risk.getRiskLevelList()) {

				System.out.println("--->" + riskLevel.getName() + ", " + riskLevel.getLowValue() + ", "
						+ riskLevel.getHighValue());

				isSugar = !isSugar ? this.isSugarValuesBetween(patientRisk, riskLevel) : isSugar;
				isFat = !isFat ? this.isFatValuesBetween(patientRisk, riskLevel) : isFat;
				isOxygen = !isOxygen ? this.isOxygenValuesBetween(patientRisk, riskLevel) : isOxygen;
			}

			System.out.println(isSugar + ", " + isFat + ", " + isOxygen);

			if (isSugar && isFat && isOxygen) {
				patientRisk.setRiskId(risk.getId());
				break;
			}

		}

		System.out.println("---->" + patientRisk);

		Optional<Patient> patient = this.patientRepository.findByDocument(patientRisk.getDocument());
		
		System.out.println("----------------->>>>"+patient);

		patientRisk.setPatient(patient.get());
		return this.patientRiskRepository.save(patientRisk);
	}

	private Boolean isSugarValuesBetween(PatientRisk patientRisk, RiskLevel riskLevel) {
		if ("SUGAR".equalsIgnoreCase(riskLevel.getName()) && this.isValuesBetween(patientRisk.getSugarPercentage(),
				riskLevel.getLowValue(), riskLevel.getHighValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private Boolean isFatValuesBetween(PatientRisk patientRisk, RiskLevel riskLevel) {
		if ("FAT".equalsIgnoreCase(riskLevel.getName()) && this.isValuesBetween(patientRisk.getFatPercentage(),
				riskLevel.getLowValue(), riskLevel.getHighValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private Boolean isOxygenValuesBetween(PatientRisk patientRisk, RiskLevel riskLevel) {
		if ("OXYGEN".equalsIgnoreCase(riskLevel.getName()) && this.isValuesBetween(patientRisk.getOxygenPercentage(),
				riskLevel.getLowValue(), riskLevel.getHighValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private Boolean isValuesBetween(Double value, Double lowValue, Double highValue) {
		if (value >= lowValue && value <= highValue) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
