package co.api.bloodtestmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "PATIENT_RISK")
public class PatientRisk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull
	@Column(name = "PATIENT_DOCUMENT")
	private Long document;
	
	@NotNull
	@Column(name = "SUGAR_PERCENT")
	private Double sugarPercentage;
	
	@NotNull
	@Column(name = "FAT_PERCENT")
	private Double fatPercentage;
	
	@NotNull
	@Column(name = "OXYGEN_PERCENT")
	private Double oxygenPercentage;
	
	@NotNull
	@Column(name = "DISEASE_ID")
	private Long diseaseId;

	@NotNull
	@Column(name = "RISK_ID")
	private Long riskId;
}
