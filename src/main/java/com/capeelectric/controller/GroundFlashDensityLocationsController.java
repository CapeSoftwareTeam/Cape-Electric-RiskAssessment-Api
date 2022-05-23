package com.capeelectric.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.GroundFlashDensity;
import com.capeelectric.service.GroundFlashDensityLocationService;

@RestController
@RequestMapping("/api/risk/v2")
public class GroundFlashDensityLocationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroundFlashDensityLocationsController.class);

	@Autowired
	private GroundFlashDensityLocationService groundFlashDensityLocationService;
	
	@GetMapping("/fetchGroundLocations")
	public List<GroundFlashDensity> fetchLocation() throws RiskAssessmentException {
		logger.debug("called fetch Ground Location");
		return groundFlashDensityLocationService.fetchLocations();
	}
}
