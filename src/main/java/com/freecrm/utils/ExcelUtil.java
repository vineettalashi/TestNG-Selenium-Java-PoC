package com.freecrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ExcelUtil {

	private static FileInputStream fis;
	private static XSSFWorkbook wb;
	
	private final static Logger logger = Logger.getLogger(ExcelUtil.class);
	
	public static Object[][] getAllTestData(String fileName, String Sheetname)
	{
		List<Object[]> results = new ArrayList<Object[]>();
		HashMap<String, String> input = new HashMap<String, String>();
		
		try {
				fis = new FileInputStream(Constants.datafilesPath + "/" + fileName + ".xlsx");
				wb = new XSSFWorkbook(fis);
			} 
		catch (IOException e) {
				logger.warn("Data excel not found!!!!");
			}
		XSSFSheet sh = wb.getSheet(Sheetname);
		int rowCount = sh.getPhysicalNumberOfRows();
		int colCount = sh.getRow(0).getLastCellNum();
		for(int row = 0; row<rowCount-1;row++)
		{
		for (int i = 0; i < colCount; i++) {
			input.put(sh.getRow(0).getCell(i).getStringCellValue(), sh.getRow(1).getCell(i).getStringCellValue());
		}
		
		results.add(new Object[]{input});
		}
		
		return results.toArray(new Object[0][]);
	}

}


/*

Try this (assuming you have actually the List<Integer[]> you talked about in your comment):

List<Integer[]> myList = new ArrayList<Integer[]>();
myList.add(new Integer[] {2,null,1,null,null,3,6,1,1} );

Integer[][] myArr = myList.toArray(new Integer[myList.size()][]);

If you convert a list of arrays to an array, you'll get a 2 dimensional array and thus your parameter should be one too.


*/