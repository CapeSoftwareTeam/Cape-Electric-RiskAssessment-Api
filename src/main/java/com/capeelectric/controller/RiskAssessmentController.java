package com.capeelectric.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.StructureCharacteristics;
import com.capeelectric.service.RiskAssessmentService;

@RestController
@RequestMapping("/api/risk/v2")
public class RiskAssessmentController {

	private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentController.class);

	@Autowired
	private RiskAssessmentService riskAssessmentService;

	@PostMapping("/saveRiskAssessmentDetails")
	public ResponseEntity<String> saveRiskAssessmentDetails(
			@RequestBody StructureCharacteristics structureCharacteristics) throws RiskAssessmentException {
		logger.debug("started addRiskAssessmentDetails function userName: {},riskId : {}",
				structureCharacteristics.getUserName(), structureCharacteristics.getRiskId());
		riskAssessmentService.addRiskAssessmentDetails(structureCharacteristics);
		logger.debug("ended saveRiskAssessmentDetails function");
		return new ResponseEntity<String>("RiskAssessmentDetails  Details Saved Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/retrieveRiskAssessmentDetails/{userName}/{riskId}")
	public ResponseEntity<List<StructureCharacteristics>> retrieveRiskAssessmentDetails(@PathVariable String userName,
			@PathVariable Integer riskId) throws RiskAssessmentException {
		logger.info("called retrieveRiskAssessmentDetails function UserName: {}, riskId : {}", userName, riskId);
		return new ResponseEntity<List<StructureCharacteristics>>(
				riskAssessmentService.retrieveRiskAssessmentDetails(userName, riskId), HttpStatus.OK);
	}

	@PutMapping("/updateRiskAssessmentDetails")
	public ResponseEntity<String> updateRiskAssessmentDetails(
			@RequestBody StructureCharacteristics structureCharacteristics) throws RiskAssessmentException {
		logger.info("called updateRiskAssessmentDetails function UserName : {},getRiskId : {}",
				structureCharacteristics.getUserName());
		riskAssessmentService.updateRiskAssessmentDetails(structureCharacteristics);
		return new ResponseEntity<String>("RiskAssessmentDetails  Updated Successfully", HttpStatus.OK);
	}

}