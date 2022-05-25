package com.capeelectric.service.impl;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.CustomerDetails;
import com.capeelectric.repository.CustomerDetailsRepository;
import com.capeelectric.service.PrintRiskCustomerDetailsService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PrintRiskCustomerDetailsServiceImpl implements PrintRiskCustomerDetailsService {

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Override
	public void printRiskCustomerDetails(String userName, Integer riskId) throws RiskAssessmentException {

		if (userName != null && !userName.isEmpty() && riskId != null && riskId != 0) {
			Document document = new Document(PageSize.A4, 68, 68, 62, 68);

			try {

				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("02 Customer Details.pdf"));

				List<CustomerDetails> customerDetailsRepo = customerDetailsRepository.findByRiskId(riskId);
				CustomerDetails customerDetails = customerDetailsRepo.get(0);
//				ClientDetails clientDetailsRepo1 = clientDetailsRepo.get();

				Font font8 = new Font(BaseFont.createFont(), 9, Font.NORMAL, BaseColor.BLACK);
				Font font9 = new Font(BaseFont.createFont(), 10, Font.NORMAL, BaseColor.BLACK);
				Font font11B = new Font(BaseFont.createFont(), 11, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
				Font font12B = new Font(BaseFont.createFont(), 12, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
				Font font10N = new Font(BaseFont.createFont(), 10, Font.NORMAL, BaseColor.BLACK);

				document.open();

				float[] pointColumnWidths40 = { 100F };

				PdfPTable headertable = new PdfPTable(pointColumnWidths40);
				headertable.setWidthPercentage(100); // Width 100%
				headertable.setSpacingBefore(10f); // Space before table

				PdfPCell label = new PdfPCell(new Paragraph("RISK ASSESMENT REPORT", font11B));
				label.setHorizontalAlignment(Element.ALIGN_CENTER);
				label.setGrayFill(0.92f);
				label.setFixedHeight(20f);
				headertable.addCell(label);
				document.add(headertable);

				float[] pointColumnWidths = { 15F, 60F, 105F };
				PdfPTable table100 = new PdfPTable(pointColumnWidths);

				table100.setWidthPercentage(100); // Width 100%
				table100.setSpacingBefore(10f); // Space before table
				table100.setSpacingAfter(5f); // Space after table
				table100.getDefaultCell().setBorder(15);

				

				PdfPCell cell4 = new PdfPCell(new Paragraph("01", font10N));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell4);

				PdfPCell cell5 = new PdfPCell(new Paragraph("Organisation Name", font10N));
				cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell5);

				PdfPCell cell6 = new PdfPCell(new Paragraph(customerDetails.getOrganisationName(), font10N));
				cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell6);

				PdfPCell cell7 = new PdfPCell(new Paragraph("02", font10N));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell7);

				PdfPCell cell8 = new PdfPCell(new Paragraph("Address", font10N));
				cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell8);

				PdfPCell cell9 = new PdfPCell(new Paragraph(customerDetails.getAddress(), font10N));
				cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell9);

				PdfPCell cell10 = new PdfPCell(new Paragraph("03", font10N));
				cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell10);

				PdfPCell cell11 = new PdfPCell(new Paragraph("Project Name", font10N));
				cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell11);

				PdfPCell cell12 = new PdfPCell(new Paragraph(customerDetails.getProjectName(), font10N));
				cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell12);

				PdfPCell cell13 = new PdfPCell(new Paragraph("04", font10N));
				cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell13);

				PdfPCell cell14 = new PdfPCell(new Paragraph("Project Description", font10N));
				cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell14);

				PdfPCell cell15 = new PdfPCell(new Paragraph(customerDetails.getProjectDescription(), font10N));
				cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell15);

				PdfPCell cell16 = new PdfPCell(new Paragraph("05", font10N));
				cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell16);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Contact Person Name", font10N));
				cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell17);

				PdfPCell cell18 = new PdfPCell(new Paragraph(customerDetails.getContactPersonName(), font10N));
				cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell18);

				PdfPCell cell19 = new PdfPCell(new Paragraph("06", font10N));
				cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell19);

				PdfPCell cell20 = new PdfPCell(new Paragraph("Contact Number", font10N));
				cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell20);

				PdfPCell cell21 = new PdfPCell(new Paragraph(customerDetails.getContactNumber(), font10N));
				cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell21);

				PdfPCell cell22 = new PdfPCell(new Paragraph("07", font10N));
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell22);

				PdfPCell cell23 = new PdfPCell(new Paragraph("Prepared By", font10N));
				cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell23);

				PdfPCell cell24 = new PdfPCell(new Paragraph(customerDetails.getPreparedBy(), font10N));
				cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell24);

				PdfPCell cell25 = new PdfPCell(new Paragraph("08", font10N));
				cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
				table100.addCell(cell25);

				PdfPCell cell26 = new PdfPCell(new Paragraph("Verified By", font10N));
				cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell26);

				PdfPCell cell27 = new PdfPCell(new Paragraph(customerDetails.getPreparedBy(), font10N));
				cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
				table100.addCell(cell27);
				document.add(table100);

				

				document.close();
				writer.close();

			} catch (

			Exception e) {
				e.printStackTrace();
			}

		} else

		{
			throw new RiskAssessmentException("Invalid Inputs");
		}

	}
}
