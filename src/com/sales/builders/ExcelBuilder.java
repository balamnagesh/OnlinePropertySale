package com.sales.builders;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
 




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sales.admin.model.AgentRegistrationModel;



public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("enter into excel builder");
		List<AgentRegistrationModel> listcamps = (List) model.get("listagents");
		
		HSSFSheet sheet = workbook.createSheet("LIST OF AGENTS");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("ADDRESS");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("CITY");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("COUNTRY");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("DATEOFBIRTH");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("DATEOFJOINING");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("EMAILID");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("FIRSTNAME");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("GENDER");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("LANGUAGE");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("LASTNAME");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("MIDDLENAME");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("MOBILENUMBER");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("PINCODE");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("STATE");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("TYPE");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("USERNAME");
        header.getCell(16).setCellStyle(style);
      
        
        
        // create data rows
        int rowCount = 1;
         
        for (Iterator iterator = listcamps.iterator(); iterator.hasNext();) {
        	System.out.println("enter into iterator");
        	AgentRegistrationModel agent = (AgentRegistrationModel) iterator.next();
			  HSSFRow aRow = sheet.createRow(rowCount++);
	            aRow.createCell(0).setCellValue(agent.getId());
	            aRow.createCell(1).setCellValue(agent.getAddress());
	            aRow.createCell(2).setCellValue(agent.getCity());
	            aRow.createCell(3).setCellValue(agent.getCountry());
	            aRow.createCell(4).setCellValue(agent.getDateofbirth());
	            aRow.createCell(5).setCellValue(agent.getDateofjoining());
	            aRow.createCell(6).setCellValue(agent.getEmail());
	            aRow.createCell(7).setCellValue(agent.getFirstname());
	            aRow.createCell(8).setCellValue(agent.getGender());
	            aRow.createCell(9).setCellValue(agent.getLanguage());
	            aRow.createCell(10).setCellValue(agent.getLastname());
	            aRow.createCell(11).setCellValue(agent.getMiddlename());
	            aRow.createCell(12).setCellValue(agent.getMobileno());
	            aRow.createCell(13).setCellValue(agent.getPincode());
	            aRow.createCell(14).setCellValue(agent.getState());
	            aRow.createCell(15).setCellValue(agent.getType());
	            aRow.createCell(16).setCellValue(agent.getUsername());
	            
			
		}
	      
    	String aa="listofagents.xls";
    	res.addHeader("Content-Disposition", "attachment;filename="+aa);
	}

}
