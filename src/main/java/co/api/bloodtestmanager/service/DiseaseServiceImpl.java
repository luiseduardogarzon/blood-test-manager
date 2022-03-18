package co.api.bloodtestmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.api.bloodtestmanager.entity.Disease;
import co.api.bloodtestmanager.repository.DiseaseRepository;

@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	private DiseaseRepository diseaseRepository;

	@Override
	public Disease getDiseaseById(Long id) {
		Optional<Disease> disease = this.diseaseRepository.findById(id);
		if (disease.isPresent()) {
			return disease.get();
		}
		throw new RuntimeException("Disease not found for id: " + id);
	}
}
