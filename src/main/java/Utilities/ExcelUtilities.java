package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public FileInputStream inputStream;
	public FileOutputStream outputStream;
	public XSSFWorkbook workbook;
	public	XSSFSheet sheet;
	public	XSSFRow row;
	public XSSFCell cell;
	String filePathString;

	
	public ExcelUtilities(String pathString) {
		this.filePathString = pathString;
		
	}
	public void loadWorkBook() throws IOException {
		if(workbook==null) {
			inputStream = new FileInputStream(filePathString);
			workbook = new XSSFWorkbook(inputStream);
		}
	}
	
	public String getSheetName(int no) throws IOException {
		loadWorkBook();
		String sheetNameString = workbook.getSheetName(no);
		return sheetNameString;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		loadWorkBook();
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return rowCount;
	}
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		loadWorkBook();
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
		
	}
	public String getCelldata(String sheetName, int rownum, int columnNum) throws IOException {
		loadWorkBook();
		sheet = workbook.getSheet(sheetName);
		 row = sheet.getRow(rownum);
		 cell = row.getCell(columnNum);
		 
		 DataFormatter formatter = new DataFormatter();
		 String dataString;
		 try {
			 dataString = formatter.formatCellValue(cell);
					 
		 }catch (Exception e) {
			// TODO: handle exception
			 dataString = "nullValue";
		}
		
		workbook.close();
		inputStream.close();
		return dataString;
	}

public Map<String,String> readDataForPetExcel1(String sheetName, int rowNum, int cellNum){
		 DataFormatter formatter = new DataFormatter();
		 HashMap<String, String> data = new HashMap<>();
		
		try{
			loadWorkBook();
			sheet= workbook.getSheet(sheetName);
			XSSFRow headerRow = sheet.getRow(0);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell headerCell = headerRow.getCell(cellNum);
			XSSFCell celldataCell = row.getCell(cellNum);
			
			data.put(headerCell.getStringCellValue(), celldataCell!=null? formatter.formatCellValue(celldataCell) : " ");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
public void closebook() throws IOException {

	if(workbook!=null || inputStream!=null)
	workbook.close();
	inputStream.close();
}

	
}
