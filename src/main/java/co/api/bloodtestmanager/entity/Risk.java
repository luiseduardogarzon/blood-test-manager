package co.api.bloodtestmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "RISK")
public class Risk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "RISK_NAME")
	private String riskName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISEASE_ID")
	private Disease disease;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "risk", fetch = FetchType.LAZY)
	private List<RiskLevel> riskLevelList;
}
