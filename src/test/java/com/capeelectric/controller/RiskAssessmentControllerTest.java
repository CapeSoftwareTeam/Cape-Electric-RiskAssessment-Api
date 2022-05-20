package com.capeelectric.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.StructureCharacteristics;
import com.capeelectric.service.RiskAssessmentService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class RiskAssessmentControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentControllerTest.class);

	@InjectMocks
	private RiskAssessmentController riskAssessmentController;

	@MockBean
	private RiskAssessmentService riskAssessmentService;

	private StructureCharacteristics structureCharacteristics;

	{
		structureCharacteristics = new StructureCharacteristics();
		structureCharacteristics.setStructureCharacteristicsId(1);
		structureCharacteristics.setRiskId(10);
		structureCharacteristics.setUserName("test@capeindia.net");

	}
	
	@Test
	public void testSaveRiskAssessmentDetails() throws RiskAssessmentException {
		logger.info("testsaveRiskAssessmentDetails Function Started");
		ResponseEntity<String> addRiskAssessment = riskAssessmentController.saveRiskAssessmentDetails(structureCharacteristics);
		assertEquals(addRiskAssessment.getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void testRetrieveRiskAssessmentDetails() throws RiskAssessmentException {
		List<StructureCharacteristics> arrayList = new ArrayList<>();
		arrayList.add(structureCharacteristics);

		logger.info("testRetrieveRiskAssessmentDetails Function Started");

		when(riskAssessmentService.retrieveRiskAssessmentDetails("LVsystem@gmail.com", 1)).thenReturn(arrayList);
		ResponseEntity<List<StructureCharacteristics>> retrieveRiskAssessment = riskAssessmentController
				.retrieveRiskAssessmentDetails("LVsystem@gmail.com", 12);
		assertEquals(HttpStatus.OK, retrieveRiskAssessment.getStatusCode());

		logger.info("testRetrieveRiskAssessmentDetails Function Ended");

	}

	@Test
	public void testUpdateRiskAssessmentDetails() throws RiskAssessmentException {

		logger.info("testUpdateRiskAssessmentDetails Function Started");
		ResponseEntity<String> expectedResponseEntity = new ResponseEntity<String>(HttpStatus.OK);
		ResponseEntity<String> actualResponseEntity = riskAssessmentController.updateRiskAssessmentDetails(structureCharacteristics);
		assertEquals(actualResponseEntity.getStatusCode(), expectedResponseEntity.getStatusCode());
		logger.info("testUpdateRiskAssessmentDetails Function Ended");
	}


}
