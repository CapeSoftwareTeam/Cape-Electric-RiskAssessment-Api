package com.capeelectric.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.GroundFlashDensity;
import com.capeelectric.service.GroundFlashDensityLocationService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class GroundFlashDensityLocationsControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(GroundFlashDensityLocationsControllerTest.class);

	@InjectMocks
	private GroundFlashDensityLocationsController groundFlashDensityLocationsController;

	@MockBean
	private GroundFlashDensityLocationService groundFlashDensityLocationService;

	@Test
	public void testfetchLocation() throws RiskAssessmentException {

		List<GroundFlashDensity> expectedGroundFlashDensityLocationslist = new ArrayList<>();
		GroundFlashDensity locations = new GroundFlashDensity();
		locations.setLocation("Others");
		locations.setGfdValue("0");
		expectedGroundFlashDensityLocationslist.add(locations);

		when(groundFlashDensityLocationService.fetchLocations()).thenReturn(expectedGroundFlashDensityLocationslist);
		List<GroundFlashDensity> actualGroundFlashDensityLocationslist = groundFlashDensityLocationsController
				.fetchLocation();
		assertTrue(actualGroundFlashDensityLocationslist.size() == expectedGroundFlashDensityLocationslist.size()
				&& actualGroundFlashDensityLocationslist.containsAll(expectedGroundFlashDensityLocationslist)
				&& expectedGroundFlashDensityLocationslist.containsAll(actualGroundFlashDensityLocationslist));

	}

}