package co.api.bloodtestmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.api.bloodtestmanager.entity.Disease;
import co.api.bloodtestmanager.service.DiseaseService;

@RestController
public class DiseaseController {

	@Autowired
	private DiseaseService diseaseService;

	@GetMapping("/disease/{id}")
	public ResponseEntity<Disease> getDiseaseById(@PathVariable("id") Long id) {
		return new ResponseEntity<Disease>(this.diseaseService.getDiseaseById(id), HttpStatus.OK);
	}
}
