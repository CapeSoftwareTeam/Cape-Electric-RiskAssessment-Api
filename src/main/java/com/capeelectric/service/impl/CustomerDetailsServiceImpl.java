package com.capeelectric.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) throws CustomerDetailsException {
		if (customerDetails != null && customerDetails.getUserName() != null) {
			customerDetails.setCreatedDate(LocalDateTime.now());
			customerDetails.setCreatedBy(customerDetails.getUserName());
			customerDetails.setUpdatedBy(customerDetails.getUserName());
			customerDetails.setUpdatedDate(LocalDateTime.now());
			return customerDetailsRepository.save(customerDetails);
		} else {
			logger.error("Invalid Inputs");
			throw new CustomerDetailsException("Invalid Inputs");
		}
	}

	@Override
	public List<CustomerDetails> retrieveCustomerDetails(String userName, Integer riskId)
			throws CustomerDetailsException {
		if (userName != null && !userName.isEmpty() && riskId != null) {
			List<CustomerDetails> customerDetailsRepo = customerDetailsRepository.findByRiskId(riskId);
			if (customerDetailsRepo != null && !customerDetailsRepo.isEmpty()) {
				return customerDetailsRepo;
			} else {
				logger.error("Given RiskAssessmentId doesn't exist in CustomerDetails");
				throw new CustomerDetailsException("Given RiskAssessmentId doesn't exist in CustomerDetails");
			}
		} else {
			logger.error("Invalid Inputs");
			throw new CustomerDetailsException("Invalid Inputs");
		}
	}

	@Override
	public void updateCustomerDetails(CustomerDetails customerDetails) throws CustomerDetailsException {
		if (customerDetails != null && customerDetails.getUserName() != null && customerDetails.getRiskId() != null) {
			Optional<CustomerDetails> customerDetailsRepo = customerDetailsRepository
					.findByUserNameAndRiskId(customerDetails.getUserName(), customerDetails.getRiskId());
			if (customerDetailsRepo.isPresent()
					&& customerDetailsRepo.get().getRiskId().equals(customerDetails.getRiskId())) {
				customerDetails.setUpdatedDate(LocalDateTime.now());
				customerDetails.setUpdatedBy(customerDetails.getUserName());
				customerDetailsRepository.save(customerDetails);
			} else {
				logger.error("Given RiskAssessment Id is Invalid");
				throw new CustomerDetailsException("Given RiskAssessment Id is Invalid");
			}

		} else {
			logger.error("Invalid Inputs");
			throw new CustomerDetailsException("Invalid inputs");
		}

	}

}
