package com.capeelectric.service.impl;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.exception.RiskAssessmentException;
import com.capeelectric.model.Losses;
import com.capeelectric.model.StructureAttributes;
import com.capeelectric.model.StructureCharacteristics;
import com.capeelectric.repository.RiskAssessmentRepository;
import com.capeelectric.service.PrintRiskAssessmentDataDetailsService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PrintRiskAssessmentDataDetailsServiceImpl implements PrintRiskAssessmentDataDetailsService {

	@Autowired
	private RiskAssessmentRepository riskAssessmentRepository;

	@Override
	public void printRiskAssessmentDataDetails(String userName, Integer riskId) throws RiskAssessmentException {

		if (userName != null && !userName.isEmpty() && riskId != null && riskId != 0) {
			Document document = new Document(PageSize.A4, 68, 68, 62, 68);

			try {

				PdfWriter writer = PdfWriter.getInstance(document,
						new FileOutputStream("04 RiskAssessment Details.pdf"));

				Optional<StructureCharacteristics> structureCharacteristicsRepo = riskAssessmentRepository
						.findByRiskId(riskId);
				StructureCharacteristics structureCharacteristicsDetails = structureCharacteristicsRepo.get();

				List<StructureAttributes> structureAtt = structureCharacteristicsDetails.getStructureAttributes();
				StructureAttributes structureAttributes = structureAtt.get(0);

				List<Losses> loss = structureCharacteristicsDetails.getLosses();
				Losses losses = loss.get(0);

				document.open();

				Font font9 = new Font(BaseFont.createFont(), 10, Font.NORMAL, BaseColor.BLACK);

				Font font12B = new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
				Font font10B = new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD, BaseColor.BLACK);

				float[] pointColumnHeadLabel = { 100F };

				PdfPTable table1 = new PdfPTable(pointColumnHeadLabel);
				table1.setWidthPercentage(100); // Width 100%
				table1.setSpacingBefore(5f); // Space before table
				// table1.setSpacingAfter(5f); // Space after table

				PdfPCell dataCell = new PdfPCell(new Paragraph("STRUCTURE'S CHARACTERISTICS", font12B));
				dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				dataCell.setFixedHeight(20f);
				table1.addCell(dataCell);
				document.add(table1);

				float[] pointColumnWidths1 = { 90F, 90F };

				PdfPTable table = new PdfPTable(pointColumnWidths1); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				// table.setSpacingBefore(5f); // Space before table
//				table7.setSpacingAfter(10f); // Space after table
				table.getDefaultCell().setBorder(0);

				PdfPCell cell = new PdfPCell(new Paragraph("Location :", font9));
				// cell.setBorder(PdfPCell.NO_BORDER);
				cell.setGrayFill(0.92f);
				table.addCell(cell);
				PdfPCell cell1 = new PdfPCell(new Paragraph(structureCharacteristicsDetails.getLocation(), font9));
				cell1.setGrayFill(0.92f);
				// cell1.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell1);

				PdfPCell cell2 = new PdfPCell(new Paragraph("Ground flash density:", font9));
				// cell2.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getGroundFlashDensity(), font9));
				// cell3.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell3);

				PdfPCell cell126 = new PdfPCell(new Paragraph("Type of Building:", font9));
				// cell126.setBorder(PdfPCell.NO_BORDER);
				cell126.setGrayFill(0.92f);
				table.addCell(cell126);
				PdfPCell cell127 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getTypeOfBuilding(), font9));
				cell127.setGrayFill(0.92f);
				// cell127.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell127);

				PdfPCell cell120 = new PdfPCell(new Paragraph("Structure screening effectiveness:", font9));
				// cell120.setBorder(PdfPCell.NO_BORDER);
				// cell120.setGrayFill(0.92f);
				table.addCell(cell120);
				PdfPCell cell121 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getStructureScreeningEffectiveness(), font9));
				// cell121.setGrayFill(0.92f);
				// cell121.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell121);

				PdfPCell cell122 = new PdfPCell(new Paragraph("Length:", font9));
				// cell122.setBorder(PdfPCell.NO_BORDER);
				cell122.setGrayFill(0.92f);
				table.addCell(cell122);
				PdfPCell cell123 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtrusionLenght(), font9));
				cell123.setGrayFill(0.92f);
				// cell123.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell123);

				PdfPCell cell13 = new PdfPCell(new Paragraph("Width:", font9));
				// cell13.setBorder(PdfPCell.NO_BORDER);
				// cell120.setGrayFill(0.92f);
				table.addCell(cell13);
				PdfPCell cell14 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtrusionWidth(), font9));
				// cell14.setGrayFill(0.92f);
				// cell14.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell14);

				PdfPCell cell15 = new PdfPCell(new Paragraph("Height:", font9));
				// cell15.setBorder(PdfPCell.NO_BORDER);
				cell15.setGrayFill(0.92f);
				table.addCell(cell15);
				PdfPCell cell16 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtrusionHeight(), font9));
				cell16.setGrayFill(0.92f);
				// cell16.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell16);

				PdfPCell cell17 = new PdfPCell(new Paragraph("Height of highest roof protrusion:", font9));
				// cell17.setBorder(PdfPCell.NO_BORDER);
				// cell17.setGrayFill(0.92f);
				table.addCell(cell17);
				PdfPCell cell18 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getHeighestRoofProtrusion(), font9));
				// cell18.setGrayFill(0.92f);
				// cell18.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell18);

				PdfPCell cell20 = new PdfPCell(new Paragraph("Collection area of structure:", font9));
				// cell20.setBorder(PdfPCell.NO_BORDER);
				cell20.setGrayFill(0.92f);
				table.addCell(cell20);
				PdfPCell cell231 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getCollectionAreaOfStructure(), font9));
				cell231.setGrayFill(0.92f);
				// cell231.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell231);

				PdfPCell cell21 = new PdfPCell(new Paragraph("Collection area of structure with protrusion:", font9));
				// cell21.setBorder(PdfPCell.NO_BORDER);
				// cell21.setGrayFill(0.92f);
				table.addCell(cell21);
				PdfPCell cell29 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getCollAreaOfStrucWithProtrusion(), font9));
				// cell29.setGrayFill(0.92f);
				// cell29.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell29);

				PdfPCell cell212 = new PdfPCell(new Paragraph("Collection area near the structure:", font9));
				// cell212.setBorder(PdfPCell.NO_BORDER);
				cell212.setGrayFill(0.92f);
				table.addCell(cell212);
				PdfPCell cell291 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getCollAreaOfNearStructure(), font9));
				cell291.setGrayFill(0.92f);
				// cell291.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell291);

				PdfPCell cell30 = new PdfPCell(new Paragraph("Height of nearby structure:", font9));
				// cell30.setBorder(PdfPCell.NO_BORDER);
				// cell30.setGrayFill(0.92f);
				table.addCell(cell30);
				PdfPCell cell31 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getHeightNearByStructure(), font9));
				// cell31.setGrayFill(0.92f);
				// cell31.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell31);

				PdfPCell cell32 = new PdfPCell(new Paragraph("Electrical / telephone service line:", font9));
				// cell32.setBorder(PdfPCell.NO_BORDER);
				cell32.setGrayFill(0.92f);
				table.addCell(cell32);
				PdfPCell cell33 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getTelephoneServiceLine(), font9));
				cell33.setGrayFill(0.92f);
				// cell33.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell33);

				PdfPCell cell34 = new PdfPCell(new Paragraph("Environment:", font9));
				// cell34.setBorder(PdfPCell.NO_BORDER);
				// cell34.setGrayFill(0.92f);
				table.addCell(cell34);
				PdfPCell cell35 = new PdfPCell(new Paragraph(structureCharacteristicsDetails.getEnvironment(), font9));
				// cell35.setGrayFill(0.92f);
				// cell35.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell35);

				PdfPCell cell36 = new PdfPCell(new Paragraph("No. of dangerous event on structure:", font9));
				// cell36.setBorder(PdfPCell.NO_BORDER);
				cell36.setGrayFill(0.92f);
				table.addCell(cell36);
				PdfPCell cell37 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getNoOfDangerousEventOnStructure(), font9));
				cell37.setGrayFill(0.92f);
				// cell37.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell37);

				PdfPCell cell38 = new PdfPCell(new Paragraph("No. of dangerous event near the structure:", font9));
				// cell38.setBorder(PdfPCell.NO_BORDER);
				// cell38.setGrayFill(0.92f);
				table.addCell(cell38);
				PdfPCell cell39 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getNoOfDangerousEventNearStructure(), font9));
				// cell39.setGrayFill(0.92f);
				// cell39.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell39);

				PdfPCell cell40 = new PdfPCell(new Paragraph("Protection required for part of building:", font9));
				// cell40.setBorder(PdfPCell.NO_BORDER);
				cell40.setGrayFill(0.92f);
				table.addCell(cell40);
				PdfPCell cell41 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtectionPartOFBuilding(), font9));
				cell41.setGrayFill(0.92f);
				// cell41.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell41);

				PdfPCell cell42 = new PdfPCell(new Paragraph("Length:", font9));
				// cell42.setBorder(PdfPCell.NO_BORDER);
				// cell42.setGrayFill(0.92f);
				table.addCell(cell42);
				PdfPCell cell43 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtectionLenght(), font9));
				// cell43.setGrayFill(0.92f);
				// cell43.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell43);

				PdfPCell cell44 = new PdfPCell(new Paragraph("Width:", font9));
				// cell44.setBorder(PdfPCell.NO_BORDER);
				cell44.setGrayFill(0.92f);
				table.addCell(cell44);
				PdfPCell cell145 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtectionWidth(), font9));
				cell145.setGrayFill(0.92f);
				// cell145.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell145);

				PdfPCell cell46 = new PdfPCell(new Paragraph("Height:", font9));
				// cell46.setBorder(PdfPCell.NO_BORDER);
				// cell46.setGrayFill(0.92f);
				table.addCell(cell46);
				PdfPCell cell47 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtectionHeight(), font9));
				// cell47.setGrayFill(0.92f);
				// cell47.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell47);

				PdfPCell cell48 = new PdfPCell(new Paragraph("Collection area:", font9));
				// cell48.setBorder(PdfPCell.NO_BORDER);
				cell48.setGrayFill(0.92f);
				table.addCell(cell48);
				PdfPCell cell49 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getProtectionCollectionArea(), font9));
				cell49.setGrayFill(0.92f);
				// cell49.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell49);

				PdfPCell cell50 = new PdfPCell(new Paragraph("Adjacent Building:", font9));
				// cell50.setBorder(PdfPCell.NO_BORDER);
				// cell50.setGrayFill(0.92f);
				table.addCell(cell50);
				PdfPCell cell51 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getAdjacentBuilding(), font9));
				// cell51.setGrayFill(0.92f);
				// cell51.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell51);

				PdfPCell cell452 = new PdfPCell(new Paragraph("Length:", font9));
				// cell452.setBorder(PdfPCell.NO_BORDER);
				cell452.setGrayFill(0.92f);
				table.addCell(cell452);
				PdfPCell cell53 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getAdjacentLength(), font9));
				cell53.setGrayFill(0.92f);
				// cell53.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell53);

				PdfPCell cell54 = new PdfPCell(new Paragraph("Width:", font9));
				// cell54.setBorder(PdfPCell.NO_BORDER);
				// cell54.setGrayFill(0.92f);
				table.addCell(cell54);
				PdfPCell cell155 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getAdjacentWidth(), font9));
				// cell155.setGrayFill(0.92f);
				// cell155.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell155);

				PdfPCell cell56 = new PdfPCell(new Paragraph("Height:", font9));
				// cell56.setBorder(PdfPCell.NO_BORDER);
				cell56.setGrayFill(0.92f);
				table.addCell(cell56);
				PdfPCell cell57 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getAdjacentHeight(), font9));
				cell57.setGrayFill(0.92f);
				// cell57.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell57);

				PdfPCell cell58 = new PdfPCell(new Paragraph("Collection area of adjacent structure:", font9));
				// cell58.setBorder(PdfPCell.NO_BORDER);
				// cell58.setGrayFill(0.92f);
				table.addCell(cell58);
				PdfPCell cell59 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getCollAreaOfAdjacentStruc(), font9));
				// cell59.setGrayFill(0.92f);
				// cell59.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell59);

				PdfPCell cell60 = new PdfPCell(
						new Paragraph("No. of dangerous event on the adjacent \r\n" + "structure:", font9));
				// cell60.setBorder(PdfPCell.NO_BORDER);
				cell60.setGrayFill(0.92f);
				table.addCell(cell60);
				PdfPCell cell61 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getNoOfDangEventOnAdjacentStruc(), font9));
				cell61.setGrayFill(0.92f);
				// cell61.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell61);

				PdfPCell cell62 = new PdfPCell(new Paragraph("No. of people in the building:", font9));
				// cell62.setBorder(PdfPCell.NO_BORDER);
				// cell62.setGrayFill(0.92f);
				table.addCell(cell62);
				PdfPCell cell63 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getNoOfPeopleInBuilding(), font9));
				// cell63.setGrayFill(0.92f);
				// cell63.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell63);

				PdfPCell cell64 = new PdfPCell(new Paragraph("No. of people in the zone:", font9));
				// cell64.setBorder(PdfPCell.NO_BORDER);
				cell64.setGrayFill(0.92f);
				table.addCell(cell64);
				PdfPCell cell65 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getNoOfPeopleInZone(), font9));
				cell65.setGrayFill(0.92f);
				// cell65.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell65);

				PdfPCell cell66 = new PdfPCell(
						new Paragraph("Number of hours/day people are present in \r\n" + "the building:", font9));
				// cell66.setBorder(PdfPCell.NO_BORDER);
				// cell66.setGrayFill(0.92f);
				table.addCell(cell66);
				PdfPCell cell67 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getDayPeoplePresentBuilding(), font9));
				// cell67.setGrayFill(0.92f);
				// cell67.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell67);

				PdfPCell cell68 = new PdfPCell(
						new Paragraph("Number of hours/Year people are present in \r\n" + "the building:", font9));
				// cell68.setBorder(PdfPCell.NO_BORDER);
				cell68.setGrayFill(0.92f);
				table.addCell(cell68);
				PdfPCell cell69 = new PdfPCell(
						new Paragraph(structureCharacteristicsDetails.getYearPeoplePresentBuilding(), font9));
				cell69.setGrayFill(0.92f);
				// cell69.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell69);
				document.add(table);

				PdfPTable table11 = new PdfPTable(pointColumnHeadLabel);
				table11.setWidthPercentage(100); // Width 100%
				table11.setSpacingBefore(15f); // Space before table
				// table11.setSpacingAfter(5f); // Space after table

				PdfPCell dataCell1 = new PdfPCell(new Paragraph("STRUCTURE'S ATTRIBUTES", font12B));
				dataCell1.setHorizontalAlignment(Element.ALIGN_CENTER);

				dataCell.setFixedHeight(20f);
				table11.addCell(dataCell1);
				document.add(table11);

				PdfPTable table22 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table22.setWidthPercentage(100); // Width 100%
				// table22.setSpacingBefore(5f); // Space before table
//				table22.setSpacingAfter(10f); // Space after table
				table22.getDefaultCell().setBorder(0);

				PdfPCell cell70 = new PdfPCell(new Paragraph("Type of floor surface :", font9));
				// cell70.setBorder(PdfPCell.NO_BORDER);
				cell70.setGrayFill(0.92f);
				table22.addCell(cell70);
				PdfPCell cell72 = new PdfPCell(new Paragraph(structureAttributes.getStTypeOfFloorSurface(), font9));
				cell72.setGrayFill(0.92f);
				// cell72.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell72);

				PdfPCell cell73 = new PdfPCell(new Paragraph("Additional protection:", font9));
				// cell73.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell73);
				PdfPCell cell74 = new PdfPCell(new Paragraph(structureAttributes.getStAdditionalProtection(), font9));
				// cell74.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell74);

				PdfPCell cell75 = new PdfPCell(new Paragraph("Risk of fire:", font9));
				cell75.setGrayFill(0.92f);
				// cell75.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell75);
				PdfPCell cell76 = new PdfPCell(new Paragraph(structureAttributes.getStRiskOfFire(), font9));
				cell76.setGrayFill(0.92f);
				// cell76.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell76);

				PdfPCell cell78 = new PdfPCell(new Paragraph("Fire protection measures:", font9));
				// cell78.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell78);
				PdfPCell cell79 = new PdfPCell(new Paragraph(structureAttributes.getStFireProtectionMeasure(), font9));
				// cell79.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell79);

				PdfPCell cell80 = new PdfPCell(new Paragraph("Type of internal wiring:", font9));
				cell80.setGrayFill(0.92f);
				// cell80.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell80);
				PdfPCell cell81 = new PdfPCell(new Paragraph(structureAttributes.getStTypeOfInternalWiring(), font9));
				cell81.setGrayFill(0.92f);
				// cell81.setBorder(PdfPCell.NO_BORDER);
				table22.addCell(cell81);
				document.add(table22);

				PdfPTable table3 = new PdfPTable(pointColumnHeadLabel);
				table3.setWidthPercentage(100); // Width 100%
				table3.setSpacingBefore(15f); // Space before table
//				SystemRoomShieldTable.setSpacingAfter(5f); // Space after table

				PdfPCell shieldCell = new PdfPCell(new Paragraph("INCOMING LINES", font12B));
				shieldCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				shieldCell.setBackgroundColor(new GrayColor(0.93f));
				shieldCell.setFixedHeight(17f);
				table3.addCell(shieldCell);
				document.add(table3);

				PdfPTable table4 = new PdfPTable(pointColumnWidths1);
				table4.setWidthPercentage(100); // Width 100%
				// table4.setSpacingBefore(10f); // Space before table
				table4.getDefaultCell().setBorder(0);

				PdfPCell cell112 = new PdfPCell(new Paragraph("Total No. of lines:", font9));
				// cell112.setBorder(PdfPCell.NO_BORDER);
				cell112.setGrayFill(0.92f);
				table4.addCell(cell112);
				PdfPCell cell113 = new PdfPCell(new Paragraph(structureAttributes.getTotalNoOfLines(), font9));
				cell113.setGrayFill(0.92f);
				// cell113.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell113);

				PdfPCell cell114 = new PdfPCell(new Paragraph("Number of power lines:", font9));
				// cell114.setBorder(PdfPCell.NO_BORDER);
				// cell114.setGrayFill(0.92f);
				table4.addCell(cell114);
				PdfPCell cell115 = new PdfPCell(new Paragraph(structureAttributes.getNoOfPowerLines(), font9));
				// cell115.setGrayFill(0.92f);
				// cell115.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell115);

				PdfPCell cell110 = new PdfPCell(new Paragraph("Type of Power lines:", font9));
				// cell110.setBorder(PdfPCell.NO_BORDER);
				cell110.setGrayFill(0.92f);
				table4.addCell(cell110);
				PdfPCell cell111 = new PdfPCell(new Paragraph(structureAttributes.getTypeOfPowerLines(), font9));
				cell111.setGrayFill(0.92f);
				// cell111.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell111);

				PdfPCell cell116 = new PdfPCell(new Paragraph("Length of Power line :", font9));
				// cell116.setBorder(PdfPCell.NO_BORDER);
				// cell116.setGrayFill(0.92f);
				table4.addCell(cell116);
				PdfPCell cell117 = new PdfPCell(new Paragraph(structureAttributes.getLengthOfPowerLines(), font9));
				// cell117.setGrayFill(0.92f);
				// cell117.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell117);

				PdfPCell cell118 = new PdfPCell(new Paragraph("Shielding, grounding, isolation:", font9));
				// cell118.setBorder(PdfPCell.NO_BORDER);
				cell118.setGrayFill(0.92f);
				table4.addCell(cell118);
				PdfPCell cell119 = new PdfPCell(
						new Paragraph(structureAttributes.getShieldingGroundingIsolation(), font9));
				cell119.setGrayFill(0.92f);
				// cell119.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell119);

				PdfPCell cell200 = new PdfPCell(new Paragraph("Collection area of the Power lines:", font9));
				// cell200.setBorder(PdfPCell.NO_BORDER);
				// cell200.setGrayFill(0.92f);
				table4.addCell(cell200);
				PdfPCell cell201 = new PdfPCell(new Paragraph(structureAttributes.getCollAreaOfPowerLines(), font9));
				// cell201.setGrayFill(0.92f);
				// cell201.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell201);

				PdfPCell cell202 = new PdfPCell(new Paragraph("Collection area near the lines:", font9));
				// cell202.setBorder(PdfPCell.NO_BORDER);
				cell202.setGrayFill(0.92f);
				table4.addCell(cell202);
				PdfPCell cell203 = new PdfPCell(new Paragraph(structureAttributes.getCollAreaOfNearLines(), font9));
				cell203.setGrayFill(0.92f);
				// cell203.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell203);

				PdfPCell cell204 = new PdfPCell(new Paragraph("No. of dangerous event near the Power lines:", font9));
				// cell204.setBorder(PdfPCell.NO_BORDER);
				// cell204.setGrayFill(0.92f);
				table4.addCell(cell204);
				PdfPCell cell205 = new PdfPCell(new Paragraph(structureAttributes.getEventNearThePowerLines(), font9));
				// cell205.setGrayFill(0.92f);
				// cell205.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell205);

				PdfPCell cell206 = new PdfPCell(new Paragraph("No. of dangerous event on the Power lines:", font9));
				// cell206.setBorder(PdfPCell.NO_BORDER);
				cell206.setGrayFill(0.92f);
				table4.addCell(cell206);
				PdfPCell cell207 = new PdfPCell(new Paragraph(structureAttributes.getEventOnThePowerLines(), font9));
				cell207.setGrayFill(0.92f);
				// cell207.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell207);

				PdfPCell cell209 = new PdfPCell(new Paragraph("Number of telecommunication lines:", font9));
				// cell209.setBorder(PdfPCell.NO_BORDER);
				// cell209.setGrayFill(0.92f);
				table4.addCell(cell209);
				PdfPCell cell300 = new PdfPCell(new Paragraph(structureAttributes.getNoOfTelecomLines(), font9));
				// cell300.setGrayFill(0.92f);
				// cell300.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell300);

				PdfPCell cell301 = new PdfPCell(new Paragraph("Type of Telecom lines:", font9));
				// cell301.setBorder(PdfPCell.NO_BORDER);
				cell301.setGrayFill(0.92f);
				table4.addCell(cell301);
				PdfPCell cell302 = new PdfPCell(new Paragraph(structureAttributes.getTypeOfTelecomLines(), font9));
				cell302.setGrayFill(0.92f);
				// cell302.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell302);

				PdfPCell cell303 = new PdfPCell(new Paragraph("Length of Telecom line (In meters):", font9));
				// cell303.setBorder(PdfPCell.NO_BORDER);
				// cell303.setGrayFill(0.92f);
				table4.addCell(cell303);
				PdfPCell cell304 = new PdfPCell(new Paragraph(structureAttributes.getLengthOfTelecomLines(), font9));
				// cell304.setGrayFill(0.92f);
				// cell304.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell304);

				PdfPCell cell305 = new PdfPCell(new Paragraph("Shielding, grounding, isolation:", font9));
				// cell305.setBorder(PdfPCell.NO_BORDER);
				cell305.setGrayFill(0.92f);
				table4.addCell(cell305);
				PdfPCell cell306 = new PdfPCell(
						new Paragraph(structureAttributes.getShieldingGroundingIsolationL1(), font9));
				cell306.setGrayFill(0.92f);
				// cell306.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell306);

				PdfPCell cell307 = new PdfPCell(new Paragraph("Collection area of the Telecom lines:", font9));
				// cell307.setBorder(PdfPCell.NO_BORDER);
				// cell307.setGrayFill(0.92f);
				table4.addCell(cell307);
				PdfPCell cell308 = new PdfPCell(new Paragraph(structureAttributes.getCollAreaOfTelecomLines(), font9));
				// cell308.setGrayFill(0.92f);
				// cell308.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell308);

				PdfPCell cell309 = new PdfPCell(new Paragraph("Collection area near the Telecom lines:", font9));
				// cell309.setBorder(PdfPCell.NO_BORDER);
				cell309.setGrayFill(0.92f);
				table4.addCell(cell309);
				PdfPCell cell310 = new PdfPCell(new Paragraph(structureAttributes.getCollNearOfTelecomLines(), font9));
				cell310.setGrayFill(0.92f);
				// cell310.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell310);

				PdfPCell cell311 = new PdfPCell(new Paragraph("No. of dangerous event near the Telecom lines:", font9));
				// cell311.setBorder(PdfPCell.NO_BORDER);
				// cell311.setGrayFill(0.92f);
				table4.addCell(cell311);
				PdfPCell cell312 = new PdfPCell(
						new Paragraph(structureAttributes.getEventNearTheTelecomeLines(), font9));
				// cell312.setGrayFill(0.92f);
				// cell312.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell312);

				PdfPCell cell313 = new PdfPCell(new Paragraph("No. of dangerous event on the Telecom lines:", font9));
				// cell313.setBorder(PdfPCell.NO_BORDER);
				cell313.setGrayFill(0.92f);
				table4.addCell(cell313);
				PdfPCell cell314 = new PdfPCell(new Paragraph(structureAttributes.getEventOnTheTelecomLines(), font9));
				cell314.setGrayFill(0.92f);
				// cell314.setBorder(PdfPCell.NO_BORDER);
				table4.addCell(cell314);

				document.add(table4);

				PdfPTable table5 = new PdfPTable(pointColumnHeadLabel);
				table5.setWidthPercentage(100); // Width 100%
				table5.setSpacingBefore(15f); // Space before table
//				SiteRFSourceTable.setSpacingAfter(5f); // Space after table

				PdfPCell dataCell6 = new PdfPCell(new Paragraph("LOSS OF HUMAN LIFE (L1)", font12B));
				dataCell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				dataCell6.setBackgroundColor(new GrayColor(0.93f));
				dataCell6.setFixedHeight(17f);
				table5.addCell(dataCell6);
				document.add(table5);

				PdfPTable table6 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table6.setWidthPercentage(100); // Width 100%
				// table6.setSpacingBefore(10f); // Space before table
//				table6.setSpacingAfter(10f); // Space after table
				table6.getDefaultCell().setBorder(0);

				PdfPCell cell24 = new PdfPCell(new Paragraph("Hazard classification", font9));
				// cell24.setBorder(PdfPCell.NO_BORDER);
				cell24.setGrayFill(0.92f);
				table6.addCell(cell24);
				PdfPCell cell25 = new PdfPCell(new Paragraph(losses.getHazardClassification(), font9));
				cell25.setGrayFill(0.92f);
				// cell25.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell25);

				PdfPCell cell132 = new PdfPCell(new Paragraph("Loss due to Physical damage:", font9));
				// cell132.setBorder(PdfPCell.NO_BORDER);
				// cell132.setGrayFill(0.92f);
				table6.addCell(cell132);
				PdfPCell cell133 = new PdfPCell(new Paragraph(losses.getHumanLossOfphysicalDamage(), font9));
				// cell133.setGrayFill(0.92f);
				// cell133.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell133);

				PdfPCell cell134 = new PdfPCell(new Paragraph("Loss due to failure of internal system :", font9));
				// cell134.setBorder(PdfPCell.NO_BORDER);
				cell134.setGrayFill(0.92f);
				table6.addCell(cell134);
				PdfPCell cell135 = new PdfPCell(new Paragraph(losses.getHumanLossOffailureOfInternalSystem(), font9));
				cell135.setGrayFill(0.92f);
				// cell135.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell135);

				PdfPCell cell136 = new PdfPCell(
						new Paragraph("Loss due to injury to living beings by electric shock:", font9));
				// cell136.setBorder(PdfPCell.NO_BORDER);
				// cell136.setGrayFill(0.92f);
				table6.addCell(cell136);
				PdfPCell cell137 = new PdfPCell(new Paragraph(losses.getHumanLossOfInjuryOfElectricShock(), font9));
				// cell137.setGrayFill(0.92f);
				// cell137.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell137);

				PdfPCell cell1361 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell1361.setBorder(PdfPCell.NO_BORDER);
				cell1361.setGrayFill(0.92f);
				table6.addCell(cell1361);
				PdfPCell cell1371 = new PdfPCell(new Paragraph(losses.getHumanLossOfPhysicalDamageL1(), font9));
				cell1371.setGrayFill(0.92f);
				// cell1371.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell1371);

				PdfPCell cell1362 = new PdfPCell(new Paragraph("Loss due to failure of internal systems:", font9));
				// cell1362.setBorder(PdfPCell.NO_BORDER);
				// cell1362.setGrayFill(0.92f);
				table6.addCell(cell1362);
				PdfPCell cell1373 = new PdfPCell(
						new Paragraph(losses.getHumanLossOffailureOfInternalSystemL1(), font9));
				// cell1373.setGrayFill(0.92f);
				// cell1373.setBorder(PdfPCell.NO_BORDER);
				table6.addCell(cell1373);
				document.add(table6);

				PdfPTable tableData6 = new PdfPTable(pointColumnHeadLabel);
				tableData6.setWidthPercentage(100); // Width 100%
				tableData6.setSpacingBefore(15f); // Space before table
//				tableData6.setSpacingAfter(5f); // Space after table

				PdfPCell dataCell8 = new PdfPCell(new Paragraph("LOSS OF SERVICE TO PUBLIC (L2)", font12B));
				dataCell8.setHorizontalAlignment(Element.ALIGN_CENTER);
				dataCell8.setBackgroundColor(new GrayColor(0.93f));
				dataCell8.setFixedHeight(17f);
				tableData6.addCell(dataCell8);
				document.add(tableData6);

				PdfPTable table7 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table7.setWidthPercentage(100); // Width 100%
				// table7.setSpacingBefore(10f); // Space before table
//				table7.setSpacingAfter(10f); // Space after table
				table7.getDefaultCell().setBorder(0);

				PdfPCell cell701 = new PdfPCell(new Paragraph("Loss due to Physical damage:", font9));
				// cell701.setBorder(PdfPCell.NO_BORDER);
				cell701.setGrayFill(0.92f);
				table7.addCell(cell701);
				PdfPCell cell712 = new PdfPCell(new Paragraph(losses.getSerToPubPhysicalDamage(), font9));
				cell712.setGrayFill(0.92f);
				// cell712.setBorder(PdfPCell.NO_BORDER);
				table7.addCell(cell712);

				PdfPCell cell713 = new PdfPCell(new Paragraph("Loss due to failure of internal system:", font9));
				// cell713.setBorder(PdfPCell.NO_BORDER);
				// cell713.setGrayFill(0.92f);
				table7.addCell(cell713);
				PdfPCell cell432 = new PdfPCell(new Paragraph(losses.getSerToPubfailureOfInternalSystem(), font9));
				// cell432.setGrayFill(0.92f);
				// cell432.setBorder(PdfPCell.NO_BORDER);
				table7.addCell(cell432);

				PdfPCell cell7012 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell7012.setBorder(PdfPCell.NO_BORDER);
				cell7012.setGrayFill(0.92f);
				table7.addCell(cell7012);
				PdfPCell cell7127 = new PdfPCell(new Paragraph(losses.getSerToPubPhysicalDamageL1(), font9));
				cell7127.setGrayFill(0.92f);
				// cell7127.setBorder(PdfPCell.NO_BORDER);
				table7.addCell(cell7127);

				PdfPCell cell7013 = new PdfPCell(new Paragraph("Loss due to failure of internal systems:", font9));
				// cell7013.setBorder(PdfPCell.NO_BORDER);
				// cell7013.setGrayFill(0.92f);
				table7.addCell(cell7013);
				PdfPCell cell7123 = new PdfPCell(new Paragraph(losses.getSerToPubfailureOfInternalSystemL1(), font9));
				// cell7123.setGrayFill(0.92f);
				// cell7123.setBorder(PdfPCell.NO_BORDER);
				table7.addCell(cell7123);

				document.add(table7);

				PdfPTable table18 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table18.setWidthPercentage(100); // Width 100%
				// table18.setSpacingBefore(10f); // Space before table
//				table14.setSpacingAfter(10f); // Space after table
				table18.getDefaultCell().setBorder(0);

				PdfPTable table9 = new PdfPTable(pointColumnHeadLabel);
				table9.setWidthPercentage(100); // Width 100%
				table9.setSpacingBefore(15f); // Space before table
//				table9.setSpacingAfter(5f); // Space after table

				PdfPCell tableData9 = new PdfPCell(new Paragraph("LOSS OF CULTURAL HERITAGE (L3)", font12B));
				tableData9.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableData9.setBackgroundColor(new GrayColor(0.93f));
				tableData9.setFixedHeight(17f);
				table9.addCell(tableData9);
				document.add(table9);

				PdfPTable table21 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table21.setWidthPercentage(100); // Width 100%
				// table21.setSpacingBefore(5f); // Space before table
//				table21.setSpacingAfter(10f); // Space after table
				table21.getDefaultCell().setBorder(0);

				PdfPCell cell7018 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell7018.setBorder(PdfPCell.NO_BORDER);
				// cell7018.setGrayFill(0.92f);
				table21.addCell(cell7018);
				PdfPCell cell7129 = new PdfPCell(new Paragraph(losses.getCulHerOfPhysicalDamage(), font9));
				// cell7129.setGrayFill(0.92f);
				// cell7129.setBorder(PdfPCell.NO_BORDER);
				table21.addCell(cell7129);

				PdfPCell cell728 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell728.setBorder(PdfPCell.NO_BORDER);
				cell728.setGrayFill(0.92f);
				table21.addCell(cell728);
				PdfPCell cell731 = new PdfPCell(new Paragraph(losses.getCulHerOfPhysicalDamageL1(), font9));
				cell731.setGrayFill(0.92f);
				// cell731.setBorder(PdfPCell.NO_BORDER);
				table21.addCell(cell731);

				document.add(table21);

				PdfPTable table19 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table19.setWidthPercentage(100); // Width 100%
				// table19.setSpacingBefore(10f); // Space before table
//				table19.setSpacingAfter(10f); // Space after table
				table19.getDefaultCell().setBorder(0);

				PdfPTable table98 = new PdfPTable(pointColumnHeadLabel);
				table98.setWidthPercentage(100); // Width 100%
				table98.setSpacingBefore(15f); // Space before table
//				table98.setSpacingAfter(5f); // Space after table

				PdfPCell tableData96 = new PdfPCell(new Paragraph("ECONOMIC LOSS (L4)", font12B));
				tableData96.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableData96.setBackgroundColor(new GrayColor(0.93f));
				tableData96.setFixedHeight(17f);
				table98.addCell(tableData96);
				document.add(table98);

				PdfPCell cell7281 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell7281.setBorder(PdfPCell.NO_BORDER);
				cell7281.setGrayFill(0.92f);
				table19.addCell(cell7281);
				PdfPCell cell7321 = new PdfPCell(new Paragraph(losses.getEcoLossOfPhysicalDamage(), font9));
				cell7321.setGrayFill(0.92f);
				// cell7321.setBorder(PdfPCell.NO_BORDER);
				table19.addCell(cell7321);

				PdfPCell cell72813 = new PdfPCell(new Paragraph("Loss due to failure of internal system:", font9));
				// cell72813.setBorder(PdfPCell.NO_BORDER);
				// cell72813.setGrayFill(0.92f);
				table19.addCell(cell72813);
				PdfPCell cell73214 = new PdfPCell(new Paragraph(losses.getEcoLossOfFailureOfInternalSystem(), font9));
				// cell73214.setGrayFill(0.92f);
				// cell73214.setBorder(PdfPCell.NO_BORDER);
				table19.addCell(cell73214);

				PdfPCell cell7283 = new PdfPCell(
						new Paragraph("Loss due to injury to living beings by electric:", font9));
				// cell7283.setBorder(PdfPCell.NO_BORDER);
				cell7283.setGrayFill(0.92f);
				table19.addCell(cell7283);
				PdfPCell cell732 = new PdfPCell(new Paragraph(losses.getEcoLossOfInjuryOfElectricShock(), font9));
				cell732.setGrayFill(0.92f);
				// cell732.setBorder(PdfPCell.NO_BORDER);
				table19.addCell(cell732);

				PdfPCell cell729 = new PdfPCell(new Paragraph("Loss due to physical damage:", font9));
				// cell729.setBorder(PdfPCell.NO_BORDER);
				// cell729.setGrayFill(0.92f);
				table19.addCell(cell729);
				PdfPCell cell7320 = new PdfPCell(new Paragraph(losses.getEcoLossOfPhysicalDamageL1(), font9));
				// cell7320.setGrayFill(0.92f);
				// cell7320.setBorder(PdfPCell.NO_BORDER);
				table19.addCell(cell7320);

				PdfPCell cell72835 = new PdfPCell(new Paragraph("Loss due to failure of internal systems:", font9));
				// cell72835.setBorder(PdfPCell.NO_BORDER);
				cell72835.setGrayFill(0.92f);
				table19.addCell(cell72835);
				PdfPCell cell73212 = new PdfPCell(new Paragraph(losses.getEcoLossOfFailureOfInternalSystemL1(), font9));
				cell73212.setGrayFill(0.92f);
				// cell73212.setBorder(PdfPCell.NO_BORDER);
				table19.addCell(cell73212);
				document.add(table19);

				PdfPTable table99 = new PdfPTable(pointColumnHeadLabel);
				table99.setWidthPercentage(100); // Width 100%
				table99.setSpacingBefore(15f); // Space before table
//				table98.setSpacingAfter(5f); // Space after table

				PdfPCell tableData97 = new PdfPCell(new Paragraph("Protection", font12B));
				tableData97.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableData97.setBackgroundColor(new GrayColor(0.93f));
				tableData97.setFixedHeight(17f);
				table99.addCell(tableData97);
				document.add(table99);

				PdfPTable table20 = new PdfPTable(pointColumnWidths1); // 3 columns.
				table20.setWidthPercentage(100); // Width 100%
				// table19.setSpacingBefore(10f); // Space before table
//				table19.setSpacingAfter(10f); // Space after table
				table20.getDefaultCell().setBorder(0);

				PdfPCell cell72811 = new PdfPCell(new Paragraph("Class of LPS :", font9));
				// cell7281.setBorder(PdfPCell.NO_BORDER);
				cell72811.setGrayFill(0.92f);
				table20.addCell(cell72811);
				PdfPCell cell728111 = new PdfPCell(new Paragraph(losses.getClassOfLPS(), font9));
				cell728111.setGrayFill(0.92f);
				// cell7321.setBorder(PdfPCell.NO_BORDER);
				table20.addCell(cell728111);

				PdfPCell cell728101 = new PdfPCell(new Paragraph("Class of SPD :", font9));
				// cell7281.setBorder(PdfPCell.NO_BORDER);
				cell728101.setGrayFill(0.92f);
				table20.addCell(cell728101);
				PdfPCell cell7281011 = new PdfPCell(new Paragraph(losses.getClassOfSPD(), font9));
				cell7281011.setGrayFill(0.92f);
				// cell7321.setBorder(PdfPCell.NO_BORDER);
				table20.addCell(cell7281011);

				document.add(table20);

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
