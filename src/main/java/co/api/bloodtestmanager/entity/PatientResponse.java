package co.api.bloodtestmanager.entity;

import java.util.List;

import lombok.Data;

@Data
public class PatientResponse {
	private Long id;

	private Long document;

	private String name;

	private String lastName;

	private Integer age;

	private String email;

	private List<PatientRiskResponse> patientRiskList;
}
