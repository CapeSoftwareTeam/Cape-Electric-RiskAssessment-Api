package com.capeelectric.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.service.CustomerDetailsService;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class CustomerDetailsControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsControllerTest.class);

	@InjectMocks
	private CustomerDetailsController customerDetailsController;

	@MockBean
	private CustomerDetailsService customerDetailsService;

	private CustomerDetails customerDetails;

	{
		customerDetails = new CustomerDetails();
		customerDetails.setRiskId(10);
		customerDetails.setUserName("test@capeindia.net");

	}

	@Test
	public void testSaveCustomerDetails() throws CustomerDetailsException {
		logger.info("testsaveCustomerDetails Function Started");
		ResponseEntity<CustomerDetails> saveCustomerDetails = customerDetailsController
				.saveCustomerDetails(customerDetails);
		assertEquals(saveCustomerDetails.getStatusCode(), HttpStatus.CREATED);
		logger.info("testsaveCustomerDetails Function Ended");
	}

	@Test
	public void testRetrieveCustomerDetails() throws CustomerDetailsException {
		List<CustomerDetails> arrayList = new ArrayList<>();
		arrayList.add(customerDetails);

		logger.info("testRetrieveCustomerDetails Function Started");

		ResponseEntity<List<CustomerDetails>> retrieveCustomerDetails = customerDetailsController
				.retrieveCustomerDetails("LVsystem@gmail.com", 12);
		assertEquals(HttpStatus.OK, retrieveCustomerDetails.getStatusCode());

		logger.info("testRetrieveCustomerDetails Function Ended");

	}

	@Test
	public void testUpdateCustomerDetails() throws CustomerDetailsException {

		logger.info("testUpdateCustomerDetails Function Started");
		ResponseEntity<String> expectedResponseEntity = new ResponseEntity<String>(HttpStatus.OK);
		ResponseEntity<String> actualResponseEntity = customerDetailsController.updateCustomerDetails(customerDetails);
		assertEquals(actualResponseEntity.getStatusCode(), expectedResponseEntity.getStatusCode());
		logger.info("testUpdateCustomerDetails Function Ended");
	}

}
