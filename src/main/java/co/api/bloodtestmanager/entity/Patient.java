package co.api.bloodtestmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull(message = "Document should not be null")
	@Column(name = "DOCUMENT")
	private Long document;

	@NotBlank(message = "Name should not be empty")
	@Column(name = "NAME")
	private String name;

	@NotBlank(message = "Last Name should not be empty")
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull(message = "Age should not be null")
	@Column(name = "AGE")
	private Integer age;

	@Email
	@NotBlank(message = "Email should not be empty")
	@Column(name = "EMAIL")
	private String email;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.LAZY)
	private List<PatientRisk> patientRiskList;
}
