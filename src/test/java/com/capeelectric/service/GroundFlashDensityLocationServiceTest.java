package com.capeelectric.service;

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

import com.capeelectric.model.GroundFlashDensity;
import com.capeelectric.repository.GroundFlashDensityRepositary;
import com.capeelectric.service.impl.GroundFlashDensityLocationServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class GroundFlashDensityLocationServiceTest {

	@InjectMocks
	private GroundFlashDensityLocationServiceImpl groundFlashDensityLocationServiceImpl;

	@MockBean
	private GroundFlashDensityRepositary groundFlashDensityRepositary;

	@Test
	public void testFetchLocations() throws Exception {
		List<GroundFlashDensity> actualGroundFlashList = new ArrayList<>();
		GroundFlashDensity groundFlash = new GroundFlashDensity();
		groundFlash.setLocation("Others");
		groundFlash.setGfdValue("0");
		actualGroundFlashList.add(groundFlash);
		when(groundFlashDensityRepositary.findAll()).thenReturn(actualGroundFlashList);
		List<GroundFlashDensity> expectedGroundList = groundFlashDensityLocationServiceImpl.fetchLocations();
		expectedGroundList.sort((o1, o2) -> o1.getLocation().compareTo(o2.getLocation()));
		assertTrue(actualGroundFlashList.size() == expectedGroundList.size()
				&& actualGroundFlashList.containsAll(expectedGroundList)
				&& expectedGroundList.containsAll(actualGroundFlashList));
	}

}