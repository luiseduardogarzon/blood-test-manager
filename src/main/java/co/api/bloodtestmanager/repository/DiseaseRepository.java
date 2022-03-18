package co.api.bloodtestmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.api.bloodtestmanager.entity.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

}
