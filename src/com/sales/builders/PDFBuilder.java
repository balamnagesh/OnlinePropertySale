package com.sales.builders;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.sales.admin.model.AgentRegistrationModel;

import java.util.List;

 




import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		

		 List<AgentRegistrationModel> listagents = (List) model.get("listagents");
         
	        document.add(new Paragraph("Recommended Agents for Spring framework"));
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
	        table.setSpacingBefore(10);
	         
	        // define font for table header row
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(BaseColor.WHITE);
	         
	        // define table header cell
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setPadding(5);
	         
	        // write table header
	        cell.setPhrase(new Phrase("AGENTID", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("ADDRESS", font));
	        table.addCell(cell);
	 
	        cell.setPhrase(new Phrase("CITY", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("COUNTRY", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("DATEOFBIRTH", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("DATEOFJOINING", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("EMAILID", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("FIRSTNAME", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("GENDER", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("LANGUAGE", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("LASTNAME", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("MIDDLENAME", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("MOBILENUMBER", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("PINCODE", font));
	        
	        table.addCell(cell);
 cell.setPhrase(new Phrase("STATE", font));
	        
	        table.addCell(cell);
cell.setPhrase(new Phrase("TYPE", font));
	        
	        table.addCell(cell);
cell.setPhrase(new Phrase("USERNAME", font));
	        
	        table.addCell(cell);

	        
	        
	         
	        // write table row data
	        for (AgentRegistrationModel aGent : listagents) {
	        	table.addCell(String.valueOf(aGent.getId()));//for integer cell use string.valueof
	            table.addCell(aGent.getAddress());
	            table.addCell(aGent.getCity());
	            table.addCell(aGent.getCountry());
	            table.addCell(aGent.getDateofbirth());
	            table.addCell(aGent.getDateofjoining());
	            table.addCell(aGent.getEmail());
	            table.addCell(aGent.getFirstname());
	            table.addCell(aGent.getGender());
	            table.addCell(aGent.getLanguage());
	            table.addCell(aGent.getLastname());
	            table.addCell(aGent.getMiddlename());
	            table.addCell(aGent.getMobileno());
	            table.addCell(aGent.getPincode());
	            table.addCell(aGent.getState());
	            table.addCell(aGent.getType());
	            table.addCell(aGent.getUsername());
	         
	        }
	         
	        document.add(table);
	        String aa="listofpdfagents.pdf";
	    	res.addHeader("Content-Disposition", "attachment;filename="+aa);
	         
	    }

}
