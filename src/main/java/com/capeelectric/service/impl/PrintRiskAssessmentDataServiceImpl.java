package com.capeelectric.service.impl;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.capeelectric.exception.CustomerDetailsException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.service.PrintRiskAssessmentDataService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

@Service
public class PrintRiskAssessmentDataServiceImpl implements PrintRiskAssessmentDataService {

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Value("${s3.bucket.name}")
	private String s3BucketName;

	@Value("${access.key.id}")
	private String accessKeyId;

	@Value("${access.key.secret}")
	private String accessKeySecret;
	
	@Autowired
	private AWSS3ServiceImpl awsS3ServiceImpl;

	@Override
	public void printRiskAssessmentDataDetails(String userName, Integer riskId) throws CustomerDetailsException {

		if (userName != null && !userName.isEmpty() && riskId != null && riskId != 0) {
			Document document = new Document(PageSize.A4, 68, 68, 62, 68);

			try {

				PdfWriter writer = PdfWriter.getInstance(document,
						new FileOutputStream("RiskAssesmentDataDetails.pdf"));

				List<CustomerDetails> customerDetailsRepo = customerDetailsRepository.findByRiskId(riskId);
				CustomerDetails customerDetails = customerDetailsRepo.get(0);
//				ClientDetails clientDetailsRepo1 = clientDetailsRepo.get();

				Font font8 = new Font(BaseFont.createFont(), 9, Font.NORMAL, BaseColor.BLACK);
				Font font9 = new Font(BaseFont.createFont(), 10, Font.NORMAL, BaseColor.BLACK);
				Font font11B = new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
				Font font12B = new Font(BaseFont.createFont(), 12, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
				Font font10N = new Font(BaseFont.createFont(), 10, Font.NORMAL, BaseColor.BLACK);

				document.open();
				
				BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, accessKeySecret);
				AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
						.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

				S3Object fullObject;
				fullObject = s3Client.getObject(
						new GetObjectRequest(s3BucketName, "FirstPic.png"));
				
				System.out.println(fullObject+"hhihhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				
				
				S3ObjectInputStream qqqqqqqq = fullObject.getObjectContent();
				
				S3ObjectInputStream is = fullObject.getObjectContent();
			
				
				FileOutputStream a=new FileOutputStream("FirstPic11.png");
				int len;
				byte[] buffer = new byte[4096];
				while ((len = is.read(buffer, 0, buffer.length)) != -1) {
					a.write(buffer, 0, len);
				}
				
				
				Image image = Image.getInstance(awsS3ServiceImpl.findByName("FirstPic.png"));
//				image.scaleToFit(15, 15);
				image.setAbsolutePosition(40, 30);

				document.add(image);
				
				
				
				
				
				float[] pointColumnWidths0 = { 100F };

				PdfPTable titlebox = new PdfPTable(pointColumnWidths0);
				titlebox.setWidthPercentage(100); // Width 100%
				titlebox.setSpacingBefore(10f); // Space before table
				titlebox.getDefaultCell().setBorder(15);

				PdfPCell cell0 = new PdfPCell(new Paragraph(
						"PROTECTION AGAINST LIGHTNING – RISK ASSESSMENT REPORT \r\n AS PER IEC 62305-2 : 2010-12",
						font12B));
				cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell0.setFixedHeight(30);
//				cell0.setGrayFill(0.92f);
				titlebox.addCell(cell0);
				document.add(titlebox);
//
//				float[] pointColumnWidths40 = { 100F };
//
//				PdfPTable headertable = new PdfPTable(pointColumnWidths40);
//				headertable.setWidthPercentage(100); // Width 100%
//				headertable.setSpacingBefore(10f); // Space before table
//
//				PdfPCell label = new PdfPCell(new Paragraph("RISK ASSESMENT REPORT", font11B));
//				label.setHorizontalAlignment(Element.ALIGN_CENTER);
//				label.setGrayFill(0.92f);
//				label.setFixedHeight(20f);
//				headertable.addCell(label);
//				document.add(headertable);
//
//				float[] pointColumnWidths = { 15F, 60F, 105F };
//				PdfPTable table100 = new PdfPTable(pointColumnWidths);
//
//				table100.setWidthPercentage(100); // Width 100%
//				table100.setSpacingBefore(10f); // Space before table
//				table100.setSpacingAfter(5f); // Space after table
//				table100.getDefaultCell().setBorder(15);
//
//				PdfPCell cell1 = new PdfPCell(
//						new Paragraph("SI NO", new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD)));
//				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//				cell1.setFixedHeight(20F);
//				table100.addCell(cell1);
//
//				PdfPCell cell2 = new PdfPCell(
//						new Paragraph("Content Name", new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD)));
//				cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell2);
//
//				PdfPCell cell3 = new PdfPCell(
//						new Paragraph("Content Result", new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD)));
//				cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell3);
//
//				PdfPCell cell4 = new PdfPCell(new Paragraph("01", font10N));
//				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell4);
//
//				PdfPCell cell5 = new PdfPCell(new Paragraph("Organisation Name", font10N));
//				cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell5);
//
//				PdfPCell cell6 = new PdfPCell(new Paragraph(customerDetails.getOrganisationName(), font10N));
//				cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell6);
//
//				PdfPCell cell7 = new PdfPCell(new Paragraph("02", font10N));
//				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell7);
//
//				PdfPCell cell8 = new PdfPCell(new Paragraph("Address", font10N));
//				cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell8);
//
//				PdfPCell cell9 = new PdfPCell(new Paragraph(customerDetails.getAddress(), font10N));
//				cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell9);
//
//				PdfPCell cell10 = new PdfPCell(new Paragraph("03", font10N));
//				cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell10);
//
//				PdfPCell cell11 = new PdfPCell(new Paragraph("Project Name", font10N));
//				cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell11);
//
//				PdfPCell cell12 = new PdfPCell(new Paragraph(customerDetails.getProjectName(), font10N));
//				cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell12);
//
//				PdfPCell cell13 = new PdfPCell(new Paragraph("04", font10N));
//				cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell13);
//
//				PdfPCell cell14 = new PdfPCell(new Paragraph("Project Description", font10N));
//				cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell14);
//
//				PdfPCell cell15 = new PdfPCell(new Paragraph(customerDetails.getProjectDescription(), font10N));
//				cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell15);
//
//				PdfPCell cell16 = new PdfPCell(new Paragraph("05", font10N));
//				cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell16);
//
//				PdfPCell cell17 = new PdfPCell(new Paragraph("Contact Person Name", font10N));
//				cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell17);
//
//				PdfPCell cell18 = new PdfPCell(new Paragraph(customerDetails.getContactPersonName(), font10N));
//				cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell18);
//
//				PdfPCell cell19 = new PdfPCell(new Paragraph("06", font10N));
//				cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell19);
//
//				PdfPCell cell20 = new PdfPCell(new Paragraph("Contact Details", font10N));
//				cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell20);
//
//				PdfPCell cell21 = new PdfPCell(new Paragraph(customerDetails.getContactDetails(), font10N));
//				cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell21);
//
//				PdfPCell cell22 = new PdfPCell(new Paragraph("07", font10N));
//				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell22);
//
//				PdfPCell cell23 = new PdfPCell(new Paragraph("Prepared By", font10N));
//				cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell23);
//
//				PdfPCell cell24 = new PdfPCell(new Paragraph(customerDetails.getPreparedBy(), font10N));
//				cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell24);
//
//				PdfPCell cell25 = new PdfPCell(new Paragraph("08", font10N));
//				cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table100.addCell(cell25);
//
//				PdfPCell cell26 = new PdfPCell(new Paragraph("Verified By", font10N));
//				cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell26);
//
//				PdfPCell cell27 = new PdfPCell(new Paragraph(customerDetails.getPreparedBy(), font10N));
//				cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
//				table100.addCell(cell27);
//				document.add(table100);
//
//				PdfPTable Contentheadertable = new PdfPTable(pointColumnWidths40);
//				Contentheadertable.setWidthPercentage(100); // Width 100%
//				Contentheadertable.setSpacingBefore(5f); // Space before table
//
//				PdfPCell Contentlabel = new PdfPCell(new Paragraph("Contents", font11B));
//				Contentlabel.setHorizontalAlignment(Element.ALIGN_CENTER);
//				Contentlabel.setGrayFill(0.92f);
//				Contentlabel.setFixedHeight(20f);
//				Contentheadertable.addCell(Contentlabel);
//				document.add(Contentheadertable);
//
//				PdfPTable ContentDetailsTable = new PdfPTable(1);
//				ContentDetailsTable.setWidthPercentage(100); // Width 100%
//				ContentDetailsTable.setSpacingBefore(5f); // Space before table
////				ContentDetailsTable.setSpacingAfter(5f); // Space after table
//				ContentDetailsTable.getDefaultCell().setBorder(0);
//
//				PdfPCell Content01 = new PdfPCell(new Paragraph("\r\n" + "01. " + " Symbols And Abbreviations ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content01.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content01.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content01);
//
//				PdfPCell Content02 = new PdfPCell(new Paragraph("\r\n" + "02. " + " Introduction ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content02.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content02.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content02);
//
//				PdfPCell Content03 = new PdfPCell(new Paragraph("\r\n" + "03. " + " General Information ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content03.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content03.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content03);
//
//				PdfPCell Content04 = new PdfPCell(
//						new Paragraph("\r\n" + "04. " + " Risk Assessment Selection and Parameters ",
//								new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content04.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content04.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content04);
//
//				PdfPCell Content05 = new PdfPCell(new Paragraph("\r\n" + "05. " + " Conclusion ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content05.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content05.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content05);
//
//				PdfPCell Content06 = new PdfPCell(new Paragraph("\r\n" + "06. " + " Recommendation ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content06.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content06.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content06);
//
//				PdfPCell Content07 = new PdfPCell(new Paragraph("\r\n" + "07. " + " Legal Obligation ",
//						new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.NORMAL)));
//				Content07.setHorizontalAlignment(Element.ALIGN_LEFT);
//				Content07.setBorder(PdfPCell.NO_BORDER);
//				ContentDetailsTable.addCell(Content07);
//				document.add(ContentDetailsTable);
				
				
				
				

				document.close();
				writer.close();

			} catch (

			Exception e) {
				e.printStackTrace();
			}

		} else

		{
			throw new CustomerDetailsException("Invalid Inputs");
		}

	}
}
