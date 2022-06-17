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

import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.service.CustomerDetailsService;

@RestController
@RequestMapping("/api/risk/v2")
public class CustomerDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<CustomerDetails> saveCustomerDetails(@RequestBody CustomerDetails customerDetails)
			throws CustomerDetailsException {
		logger.debug("started saveCustomerDetails function userName: {}", customerDetails.getUserName());
		return new ResponseEntity<CustomerDetails>(customerDetailsService.saveCustomerDetails(customerDetails),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/retrieveCustomerDetails/{userName}/{riskId}")
	public ResponseEntity<List<CustomerDetails>> retrieveCustomerDetails(@PathVariable String userName,
			@PathVariable Integer riskId) throws CustomerDetailsException {
		logger.info("called retrieveCustomerDetails function UserName: {}, riskId : {}", userName, riskId);
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsService.retrieveCustomerDetails(userName, riskId),
				HttpStatus.OK);
	}
 
	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<String> updateCustomerDetails(@RequestBody CustomerDetails customerDetails)
			throws CustomerDetailsException {
		logger.info("called updateClientDetails function UserName : {},getEmcId : {}", customerDetails.getUserName());
		customerDetailsService.updateCustomerDetails(customerDetails);
		return new ResponseEntity<String>("CustomerDetails  Updated Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updateRiskAssessmentCustomerDetailsStatus")
	public ResponseEntity<String> updateRiskAssessmentCustomerDetailsStatus(@RequestBody CustomerDetails customerDetails)
			throws CustomerDetailsException {
		logger.info("called updateRiskAssessmentDetailsStatus function UserName : {}, RiskId : {}", customerDetails.getUserName(),
				customerDetails.getRiskId());
		customerDetailsService.updateRiskAssessmentCustomerDetailsStatus(customerDetails);
		logger.info("Ended updateRiskAssessmentDetailsStatus function");
		return new ResponseEntity<String>("Risk_Assessment Details has been successfully deleted", HttpStatus.OK);
	}
	
	@GetMapping("/retrieveAllCustomers/{userName}")
	public ResponseEntity<List<CustomerDetails>> retrieveCustomerAllDetails(@PathVariable String userName) throws CustomerDetailsException {
		logger.info("called retrieveCustomerAllDetails function UserName: {}", userName);
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsService.retrieveCustomerAllDetails(userName),
				HttpStatus.OK);
	}
}
