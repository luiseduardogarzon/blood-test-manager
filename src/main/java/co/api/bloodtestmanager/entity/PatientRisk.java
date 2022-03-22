package co.api.bloodtestmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Transient
	@NotNull(message = "Document should not be null")
	private Long document;

	@Column(name = "SUGAR_PERCENT")
	@NotNull(message = "Sugar percentage should not be null")
	@Min(value = 0, message = "Sugar percentage should be greater than 0")
	@Max(value = 100, message = "Sugar percentage should be smaller 100")
	private Double sugarPercentage;

	@NotNull
	@Column(name = "FAT_PERCENT")
	@NotNull(message = "Fat percentage should not be null")
	@Min(value = 0, message = "Fat percentage should be greater than 0")
	@Max(value = 100, message = "Fat percentage should be smaller 100")
	private Double fatPercentage;

	@NotNull
	@Column(name = "OXYGEN_PERCENT")
	@NotNull(message = "Oxygen percentage should not be null")
	@Min(value = 0, message = "Oxygen percentage should be greater than 0")
	@Max(value = 100, message = "Oxygen percentage should be smaller 100")
	private Double oxygenPercentage;

	@NotNull
	@Column(name = "DISEASE_ID")
	private Long diseaseId;

	@JsonIgnore
	@Column(name = "RISK_ID")
	private Long riskId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	@JsonIgnore
	@CreationTimestamp
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private Date createdAt;
}
