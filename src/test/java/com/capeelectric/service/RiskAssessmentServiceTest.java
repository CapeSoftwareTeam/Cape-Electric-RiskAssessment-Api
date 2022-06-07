package com.capeelectric.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.model.StructureCharacteristics;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.repository.RiskAssessmentRepository;
import com.capeelectric.service.impl.RiskAssessmentServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class RiskAssessmentServiceTest {

	@InjectMocks
	private RiskAssessmentServiceImpl riskAssessmentServiceImpl;

	@MockBean
	private RiskAssessmentRepository riskAssessmentRepository;

	@MockBean
	private CustomerDetailsRepository customerDetailsRepository;

	private StructureCharacteristics structureCharacteristics;

	{
		structureCharacteristics = new StructureCharacteristics();
		structureCharacteristics.setRiskId(1);
		structureCharacteristics.setUserName("LVsystem@gmail.com");

	}

	private CustomerDetails customerDetails;
	{
		customerDetails = new CustomerDetails();
		customerDetails.setRiskId(1);
		customerDetails.setUserName("LVsystem@gmail.com");
	}

	@Test
	public void testAddRiskAssessmentDetails() throws RiskAssessmentException {
		when(riskAssessmentRepository.findByRiskId(10)).thenReturn(Optional.of(structureCharacteristics));
		when(customerDetailsRepository.findByRiskId(1)).thenReturn(Optional.of(customerDetails));
		riskAssessmentServiceImpl.addRiskAssessmentDetails(structureCharacteristics);

		structureCharacteristics.setRiskId(1);
		when(riskAssessmentRepository.findByRiskId(1)).thenReturn(Optional.of(structureCharacteristics));
		RiskAssessmentException assertThrows_1 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.addRiskAssessmentDetails(structureCharacteristics));
		assertEquals(assertThrows_1.getMessage(), "Given RiskAssessment Details Already Exists");

		structureCharacteristics.setRiskId(10);
		RiskAssessmentException assertThrows_2 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.addRiskAssessmentDetails(structureCharacteristics));
		assertEquals(assertThrows_2.getMessage(), "Given Risk Id is is Not Registered in Customer Details");

		structureCharacteristics.setRiskId(1);
		structureCharacteristics.setUserName(null);
		RiskAssessmentException assertThrows_3 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.addRiskAssessmentDetails(structureCharacteristics));
		assertEquals(assertThrows_3.getMessage(), "Invalid Inputs");

	}

	@Test
	public void testRetrieveRiskAssessmentDetails() throws RiskAssessmentException {
		List<StructureCharacteristics> arrayList = new ArrayList<StructureCharacteristics>();
		arrayList.add(structureCharacteristics);

		when(riskAssessmentRepository.findByUserNameAndRiskId("LVsystem@gmail.com", 1)).thenReturn(arrayList);
		riskAssessmentServiceImpl.retrieveRiskAssessmentDetails("LVsystem@gmail.com", 1);

		RiskAssessmentException assertThrows_1 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.retrieveRiskAssessmentDetails("cape", 1));
		assertEquals(assertThrows_1.getMessage(), "Given UserName & Risk Id doesn't exist in Riak Assessment Details");

		RiskAssessmentException assertThrows_2 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.retrieveRiskAssessmentDetails(null, 1));
		assertEquals(assertThrows_2.getMessage(), "Invalid Inputs");

	}

	@Test
	public void testUpdateRiskAssessmentDetails() throws RiskAssessmentException {

		when(riskAssessmentRepository.findByRiskId(1)).thenReturn(Optional.of(structureCharacteristics));
		riskAssessmentServiceImpl.updateRiskAssessmentDetails(structureCharacteristics);

		RiskAssessmentException assertThrows_1 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.updateRiskAssessmentDetails(null));
		assertEquals(assertThrows_1.getMessage(), "Invalid inputs");

		structureCharacteristics.setRiskId(8);
		RiskAssessmentException assertThrows_2 = Assertions.assertThrows(RiskAssessmentException.class,
				() -> riskAssessmentServiceImpl.updateRiskAssessmentDetails(structureCharacteristics));
		assertEquals(assertThrows_2.getMessage(), "Given Risk Id is Invalid");

	}

}
