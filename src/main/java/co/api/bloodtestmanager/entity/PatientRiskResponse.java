package co.api.bloodtestmanager.entity;

import lombok.Data;

@Data
public class PatientRiskResponse {

	private Double sugarPercentage;

	private Double fatPercentage;

	private Double oxygenPercentage;

	private String riskLevel;
}
