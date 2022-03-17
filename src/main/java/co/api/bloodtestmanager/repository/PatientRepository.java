package co.api.bloodtestmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.api.bloodtestmanager.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
