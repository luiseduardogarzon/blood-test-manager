package co.api.bloodtestmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCUMENT")
	private Long document;

	@NotBlank
	@Column(name = "NAME")
	private String name;

	@NotBlank
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private Integer age;

	@Email
	@NotBlank
	@Column(name = "EMAIL")
	private String email;
}
