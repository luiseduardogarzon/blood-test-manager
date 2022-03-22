package co.api.bloodtestmanager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.api.bloodtestmanager.entity.PatientResponse;
import co.api.bloodtestmanager.entity.PatientRisk;
import co.api.bloodtestmanager.entity.PatientRiskResponse;
import co.api.bloodtestmanager.service.PatientRiskService;
import co.api.bloodtestmanager.service.PatientService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BloodtestmanagerApplicationTests {

	@Autowired
	private PatientRiskService patientRiskService;

	@Autowired
	private PatientService patientService;

	@Test
	@Order(1)
	public void testCreatePatientRiskLow() {
		PatientRisk patientRisk = new PatientRisk();
		patientRisk.setDocument(4512178L);
		patientRisk.setDiseaseId(1L);
		patientRisk.setSugarPercentage(40.0);
		patientRisk.setFatPercentage(50.0);
		patientRisk.setOxygenPercentage(90.0);
		this.patientRiskService.savePatientRisk(patientRisk);

		assertNotNull(this.patientService.getPatientRiskByDocument(4512178L));
	}

	@Test
	@Order(2)
	public void testCreatePatientRiskMid() {
		PatientRisk patientRisk = new PatientRisk();
		patientRisk.setDocument(5478912L);
		patientRisk.setDiseaseId(1L);
		patientRisk.setSugarPercentage(60.0);
		patientRisk.setFatPercentage(80.0);
		patientRisk.setOxygenPercentage(65.0);
		this.patientRiskService.savePatientRisk(patientRisk);

		assertNotNull(this.patientService.getPatientRiskByDocument(5478912L));
	}

	@Test
	@Order(3)
	public void testCreatePatientRiskHigh() {
		PatientRisk patientRisk = new PatientRisk();
		patientRisk.setDocument(7898745L);
		patientRisk.setDiseaseId(1L);
		patientRisk.setSugarPercentage(75.0);
		patientRisk.setFatPercentage(90.0);
		patientRisk.setOxygenPercentage(50.0);
		this.patientRiskService.savePatientRisk(patientRisk);

		assertNotNull(this.patientService.getPatientRiskByDocument(7898745L));
	}

	@Test
	@Order(4)
	public void testReadPatientRiskLow() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(4512178L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		assertThat(patientRiskReponseList).size().isGreaterThan(0);
	}

	@Test
	@Order(5)
	public void testReadPatientRiskMid() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(5478912L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		assertThat(patientRiskReponseList).size().isGreaterThan(0);
	}

	@Test
	@Order(6)
	public void testReadPatientRiskHigh() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(7898745L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		assertThat(patientRiskReponseList).size().isGreaterThan(0);
	}

	@Test
	@Order(7)
	public void testReadPatientRiskLevelLow() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(4512178L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		PatientRiskResponse patientRiskResponse = patientRiskReponseList.get(0);
		assertEquals("LOW", patientRiskResponse.getRiskLevel());
	}

	@Test
	@Order(8)
	public void testReadPatientRiskLevelMid() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(5478912L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		PatientRiskResponse patientRiskResponse = patientRiskReponseList.get(0);
		assertEquals("MIDDLE", patientRiskResponse.getRiskLevel());
	}

	@Test
	@Order(9)
	public void testReadPatientRiskLevelHigh() {
		PatientResponse patient = this.patientService.getPatientRiskByDocument(7898745L);
		List<PatientRiskResponse> patientRiskReponseList = patient.getPatientRiskList();
		PatientRiskResponse patientRiskResponse = patientRiskReponseList.get(0);
		assertEquals("HIGH", patientRiskResponse.getRiskLevel());
	}
}
