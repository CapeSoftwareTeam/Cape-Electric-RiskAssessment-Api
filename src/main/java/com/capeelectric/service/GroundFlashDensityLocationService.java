package com.capeelectric.service;

import java.util.List;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.GroundFlashDensity;

public interface GroundFlashDensityLocationService {
	
	public List<GroundFlashDensity> fetchLocations();

	public GroundFlashDensity retriveGroundFlashDensity(String location) throws RiskAssessmentException;

}
