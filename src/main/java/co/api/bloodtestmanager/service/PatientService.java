package co.api.bloodtestmanager.service;

import co.api.bloodtestmanager.entity.Patient;
import co.api.bloodtestmanager.entity.PatientResponse;

public interface PatientService {

	Patient savePatient(Patient patient);

	PatientResponse getPatientRiskByDocument(Long document);
}
