package com.capeelectric.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.service.PrintRiskAssessmentDataService;


@RestController
@RequestMapping("/api/risk/v2")
public class PrintRiskAssessmentDataController {

	private static final Logger logger = LoggerFactory.getLogger(PrintRiskAssessmentDataController.class);

	@Autowired
	private PrintRiskAssessmentDataService printRiskAssessmentDataService;

	@GetMapping("/printRiskAssessmentDetails/{userName}/{riskId}")
	public ResponseEntity<String> printRiskAssessmentDataDetails(@PathVariable String userName, @PathVariable Integer riskId)
			throws CustomerDetailsException {
		logger.info("called printRiskAssessmentDataDetails function userName: {},riskId : {}", userName, riskId);
		printRiskAssessmentDataService.printRiskAssessmentDataDetails(userName, riskId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
