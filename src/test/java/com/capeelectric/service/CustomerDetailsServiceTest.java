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

import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.service.impl.CustomerDetailsServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class CustomerDetailsServiceTest {

	@InjectMocks
	private CustomerDetailsServiceImpl customerDetailsServiceImpl;

	@MockBean
	private CustomerDetailsRepository customerDetailsRepository;

	private CustomerDetails customerDetails;
	{

		customerDetails = new CustomerDetails();
		customerDetails.setRiskId(1);
		customerDetails.setUserName("LVsystem@gmail.com");

	}

	@Test
	public void testSaveCustomerDetails() throws CustomerDetailsException {
		List<CustomerDetails> arrayList = new ArrayList<CustomerDetails>();
		arrayList.add(customerDetails);
		customerDetailsServiceImpl.saveCustomerDetails(customerDetails);

		customerDetails.setRiskId(13);
		customerDetails.setUserName(null);
		CustomerDetailsException assertThrows_2 = Assertions.assertThrows(CustomerDetailsException.class,
				() -> customerDetailsServiceImpl.saveCustomerDetails(customerDetails));
		assertEquals(assertThrows_2.getMessage(), "Invalid Inputs");

	}

	@Test
	public void testRetrieveCustomerDetails() throws CustomerDetailsException {
		List<CustomerDetails> arrayList = new ArrayList<CustomerDetails>();
		arrayList.add(customerDetails);

		when(customerDetailsRepository.findByRiskId(1)).thenReturn(arrayList);
		customerDetailsServiceImpl.retrieveCustomerDetails("LVsystem@gmail.com", 1);

		CustomerDetailsException assertThrows_1 = Assertions.assertThrows(CustomerDetailsException.class,
				() -> customerDetailsServiceImpl.retrieveCustomerDetails("LVsystem@gmail.com", 12));
		assertEquals(assertThrows_1.getMessage(), "Given RiskAssessmentId doesn't exist in CustomerDetails");

		CustomerDetailsException assertThrows_2 = Assertions.assertThrows(CustomerDetailsException.class,
				() -> customerDetailsServiceImpl.retrieveCustomerDetails(null, 1));
		assertEquals(assertThrows_2.getMessage(), "Invalid Inputs");

	}

	@Test
	public void testUpdateCustomerDetails() throws CustomerDetailsException {

		when(customerDetailsRepository.findByUserNameAndRiskId("LVsystem@gmail.com", 1))
				.thenReturn(Optional.of(customerDetails));
		customerDetailsServiceImpl.updateCustomerDetails(customerDetails);

		CustomerDetailsException assertThrows_1 = Assertions.assertThrows(CustomerDetailsException.class,
				() -> customerDetailsServiceImpl.updateCustomerDetails(null));
		assertEquals(assertThrows_1.getMessage(), "Invalid Inputs");

		customerDetails.setRiskId(8);
		CustomerDetailsException assertThrows_2 = Assertions.assertThrows(CustomerDetailsException.class,
				() -> customerDetailsServiceImpl.updateCustomerDetails(customerDetails));
		assertEquals(assertThrows_2.getMessage(), "Given RiskAssessment Id is Invalid");

	}

}
