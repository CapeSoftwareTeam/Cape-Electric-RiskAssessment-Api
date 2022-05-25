package com.capeelectric.controller;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.service.ReturnPDFService;

@RestController
@RequestMapping("api/risk/v2")
public class FinalPDFController {

	private static final Logger logger = LoggerFactory.getLogger(FinalPDFController.class);

	private final ReturnPDFService returnPDFService;

	@Autowired
	public FinalPDFController(ReturnPDFService returnPDFService) {
		this.returnPDFService = returnPDFService;
	}
	
	@GetMapping("/printFinalPDF/{userName}/{riskId}/{projectName}")
	@ResponseBody
	public ResponseEntity<byte[]> printFinalPDF(@PathVariable String userName, @PathVariable Integer riskId,@PathVariable String projectName) throws Exception {
		logger.info("called printFinalPDF function userName: {},riskId : {}, projectName : {}", userName, riskId, projectName);

		ByteArrayOutputStream downloadInputStream = returnPDFService.printFinalPDF(userName, riskId, projectName);
		String keyname = projectName + ".pdf";
		return ResponseEntity.ok().contentType(contentType(keyname))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyname + "\"")
				.body(downloadInputStream.toByteArray());
	}

	private MediaType contentType(String keyname) {
		String[] fileArrSplit = keyname.split("\\.");
		String fileExtension = fileArrSplit[fileArrSplit.length - 1];
		switch (fileExtension) {
		case "txt":
			return MediaType.TEXT_PLAIN;
		case "png":
			return MediaType.IMAGE_PNG;
		case "jpg":
			return MediaType.IMAGE_JPEG;
		case "pdf":
			return MediaType.APPLICATION_PDF;
		default:
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
}
