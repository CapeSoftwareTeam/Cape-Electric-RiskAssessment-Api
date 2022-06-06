package com.capeelectric.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.exception.RiskFinalReportException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.model.RiskFinalReport;
import com.capeelectric.model.StructureCharacteristics;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.repository.RiskAssessmentRepository;
import com.capeelectric.service.FinalReportService;

@Service
public class RiskFinalReportServiceImpl implements FinalReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(RiskFinalReportServiceImpl.class);

	@Autowired
	private RiskAssessmentRepository riskAssessmentRepository;

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Override
	public Optional<RiskFinalReport> retrieveRiskReports(String userName, Integer riskId) throws RiskFinalReportException {

		if (userName != null && !userName.isEmpty() && riskId != null) {
			RiskFinalReport riskFinalReport = new RiskFinalReport();
			riskFinalReport.setUserName(userName);
			riskFinalReport.setRiskId(riskId);

			// Customer Details Fetch
			logger.debug("fetching process started for Customer Details");
			Optional<CustomerDetails> customerDetailsRepo = customerDetailsRepository.findByUserNameAndRiskId(userName, riskId);
			logger.debug("Customer Details fetching ended");
			if (customerDetailsRepo.isPresent() && customerDetailsRepo != null) {
				riskFinalReport.setCustomerDetails(customerDetailsRepo.get());

				// FacilityData Fetch
				logger.debug("fetching process started for RiskAssessment Data");
				Optional<StructureCharacteristics> riskAssessmentRepo = riskAssessmentRepository.findByRiskId(riskId);
				logger.debug("RiskAssessment Data fetching ended");
				if (riskAssessmentRepo.isPresent() && riskAssessmentRepo != null) {
					riskFinalReport.setStructureCharacteristics(riskAssessmentRepo.get());
					
				}
			}
			return Optional.of(riskFinalReport);
		} else {
			logger.debug("Invalid Input");
			throw new RiskFinalReportException("Invalid Input");

		}
	}

	@Override
	public List<CustomerDetails> retrieveListOfCustomerDetails(String userName) throws RiskFinalReportException {
		if (userName != null) {
			try {
				logger.info("CustomerDetails fetching process started");
				List<CustomerDetails> customerDetails =  customerDetailsRepository.findByUserName(userName);
				customerDetails.sort((o1, o2) -> o1.getUpdatedDate().compareTo(o2.getUpdatedDate()));
				return customerDetails;
			} catch (Exception e) {
				logger.info("CustomerDetails fetching process faild");
				throw new RiskFinalReportException("CustomerDetails Not Available");
			}
		} else {
			throw new RiskFinalReportException("Invaild Input");
		}
	}
	
	@Override
	public List<CustomerDetails> retrieveAllCustomerDetails() throws RiskFinalReportException {
		return (List<CustomerDetails>) customerDetailsRepository.findAll();
	}
}
