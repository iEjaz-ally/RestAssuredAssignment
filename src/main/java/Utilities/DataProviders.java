package Utilities;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;



public class DataProviders {
	
	@DataProvider(name="dataProviderForPets")
	public Iterator<Object[]> getDataForPets() throws IOException{
		String filePathString = System.getProperty("user.dir") + File.separator + "TestData" + File.separator+ "Testdata.xlsx";
		//	System.out.println(filePathString+ "file path");
			ExcelUtilities utilities = new ExcelUtilities(filePathString);
			int rowCount =  utilities.getRowCount(utilities.getSheetName(1));
			int cellCount = utilities.getCellCount(utilities.getSheetName(1), 1);
			ArrayList<Object[]> list = new ArrayList<>();
		
		for(int i=1; i<=rowCount;i++) {
			HashMap<String, String> returnData = new HashMap<>();
			for(int j=0;j<cellCount;j++) {
				returnData.putAll(utilities.readDataForPetExcel1(utilities.getSheetName(1), i, j));
			
			}
			list.add(new Object[] {returnData});
		}
		utilities.closebook();
		
		return list.iterator();
	}
	@DataProvider(name="PETID")
	public String[] getPetID() throws IOException {
		
		String filePathString = System.getProperty("user.dir")+ File.separator + "TestData" + File.separator+ "TestData.xlsx";
		ExcelUtilities utilities = new ExcelUtilities(filePathString);
		int rowCount =  utilities.getRowCount(utilities.getSheetName(1));
		String[] apiDataStrings = new String[rowCount];
		for(int i = 1; i<=rowCount;i++) {
			apiDataStrings[i-1]= utilities.getCelldata(utilities.getSheetName(1), i, 0);
		}
		return apiDataStrings;
	}
	

	}

