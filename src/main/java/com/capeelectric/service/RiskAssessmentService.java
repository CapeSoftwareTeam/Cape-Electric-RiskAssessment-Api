package com.capeelectric.service;

import java.util.List;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.GroundFlashDensity;
import com.capeelectric.model.StructureCharacteristics;

public interface RiskAssessmentService {

	public void addRiskAssessmentDetails(StructureCharacteristics structureCharacteristics)
			throws RiskAssessmentException;

	public List<StructureCharacteristics> retrieveRiskAssessmentDetails(String userName, Integer riskId)
			throws RiskAssessmentException;

	public void updateRiskAssessmentDetails(StructureCharacteristics structureCharacteristics)
			throws RiskAssessmentException;

	public List<GroundFlashDensity> fetchLocations();

	public GroundFlashDensity retriveGroundFlashDensity(String location) throws RiskAssessmentException;

}
