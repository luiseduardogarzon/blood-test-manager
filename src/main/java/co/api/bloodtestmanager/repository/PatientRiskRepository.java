package co.api.bloodtestmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.api.bloodtestmanager.entity.PatientRisk;

@Repository
public interface PatientRiskRepository extends JpaRepository<PatientRisk, Long> {

}
