package com.capeelectric.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.service.impl.AWSEmailService;

@RestController
@RequestMapping("api/risk/v2")

public class MailPDFController {

	private static final Logger logger = LoggerFactory.getLogger(MailPDFController.class);

	@Autowired
	private AWSEmailService awsEmailService;

	@GetMapping("/sendPDFinMail/{userName}/{riskId}/{projectName}")
	public ResponseEntity<byte[]> sendFinalPDF(@PathVariable String userName, @PathVariable Integer riskId,
			@PathVariable String projectName) throws Exception {
		logger.info("called sendFinalPDF function userName: {},riskId : {}, projecttName : {}", userName, riskId,
				projectName);

		awsEmailService.sendEmailPDF(userName, riskId, riskId, projectName);

		return new ResponseEntity<byte[]>(HttpStatus.OK);
	}
}
