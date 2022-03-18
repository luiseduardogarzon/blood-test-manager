package co.api.bloodtestmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.api.bloodtestmanager.entity.Risk;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

}
