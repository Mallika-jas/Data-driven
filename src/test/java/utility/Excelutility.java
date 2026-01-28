package utility;

import java.io.FileInputStream;
//Used to open and read the Excel file


import java.io.IOException;
//Handles input/output exceptions while reading file


import org.apache.poi.ss.usermodel.*;
//Apache POI interfaces for Sheet, Row, Cell, Workbook


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//Used to read .xlsx Excel files

public class Excelutility {
	
	public static Object[][] getLoginData() throws IOException {
		
		
		String sheetname="Sheet1";
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\Dataprovider.xlsx");
		Workbook workbook=new XSSFWorkbook(file);
		Sheet worksheet=workbook.getSheet(sheetname);
		
		int rowcount=worksheet.getPhysicalNumberOfRows();
		int colscount=2;
		//worksheet.getRow(0).getLastCellNum();
		
		Object[][] exceldata=new Object[rowcount-1][colscount];
		
		for(int i=1;i<rowcount;i++) {
			Row rows=worksheet.getRow(i);
			for(int j=0;j<colscount;j++) {
				exceldata[i-1][j]=rows.getCell(j).toString();
			}
		}
		
		workbook.close();
		file.close();
		
		
		return exceldata;
		
	}
	
}
	
