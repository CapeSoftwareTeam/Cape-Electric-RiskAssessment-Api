package com.capeelectric.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.GroundFlashDensity;
import com.capeelectric.service.GroundFlashDensityLocationService;

@RestController
@RequestMapping("/api/risk/v2")
public class GroundFlashDensityLocationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentController.class);

	@Autowired
	private GroundFlashDensityLocationService groundFlashDensityLocationService;
	
	@GetMapping("/fetchGroundLocations")
	public List<GroundFlashDensity> fetchLocation() throws RiskAssessmentException {
		return groundFlashDensityLocationService.fetchLocations();
	}

	@GetMapping("/retriveGroundFlashDensity/{location}")
	public ResponseEntity<GroundFlashDensity> retriveGroundFlashDensity(@PathVariable String location)
			throws RiskAssessmentException {
		logger.info("called RetriveGroundFlashDensity function location: {}", location);
		return new ResponseEntity<GroundFlashDensity>(groundFlashDensityLocationService.retriveGroundFlashDensity(location),
				HttpStatus.OK);
	}

}
