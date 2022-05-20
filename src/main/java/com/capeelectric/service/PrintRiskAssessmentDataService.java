package com.capeelectric.service;

import com.capeelectric.exception.CustomerDetailsException;

public interface PrintRiskAssessmentDataService {

	public void printRiskAssessmentDataDetails(String userName, Integer riskId) throws CustomerDetailsException;

}
