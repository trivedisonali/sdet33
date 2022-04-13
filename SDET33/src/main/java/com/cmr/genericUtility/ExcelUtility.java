package com.cmr.genericUtility;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author SONALI TIWARI
 *
 * 
 *
 */
public class ExcelUtility {
	public static Workbook wb;
	public static Object openExcel;
/**
 * This method is used to fetch the single data from  excel
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @return
 * @throws Throwable
 */
	public static String fetchData(String sheetName, int rowNumber, int cellNumber) throws Throwable{
	
	  Sheet sh=wb.getSheet(sheetName);

	
	String data = sh.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	return data;
	
		
	}

	public static Object[][] fetchMultipleData(String sheetname) 
	{
		Sheet sh = wb.getSheet(sheetname);
		Object [][]arr = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i=0;i< sh.getLastRowNum();i++)
		{
				 for (int j=0;j<sh.getRow(0).getLastCellNum();j++) 
				 {
				
					arr [i][j]=sh.getRow(i+1).getCell(j).toString();
				}
		}
		return arr;	
}


/**
 * This method is used to create/write the data to new row into specified excel sheet
 * @param path
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @throws Throwable
 */

public static void writeDataInNewRow(String path, String sheetName, int rowNumber, int cellNumber, String data) throws Throwable{
	
	 Sheet sh = wb.getSheet(sheetName);
	sh.createRow(rowNumber).createCell(cellNumber).setCellValue(data);
	FileOutputStream fosexcel = new FileOutputStream(path);
	
	wb.write(fosexcel);
	System.out.println("data is written successfully");

}
/**
 * this method is used for close the excel file
 * @param path
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @throws Throwable
 */

public static void writeDataInExistingRow(String path, String sheetName, int rowNumber, int cellNumber,String data) throws Throwable{
	
	Sheet sh = wb.getSheet(sheetName);
	sh.createRow(rowNumber).createCell(cellNumber).setCellValue(data);
	FileOutputStream fosexcel = new FileOutputStream(path);
	
	wb.write(fosexcel);
	System.out.println("data is written successfully");
}


/**
 * This method is used for open the excel file
 * @param path
 * @throws Throwable
 */
public static void openExcel(String path) throws Throwable {
	
	FileInputStream fisExcel =new FileInputStream(path);
	
	wb = WorkbookFactory.create(fisExcel);
	System.out.println("excel p successfully");
}


/**
 * this method is used for close the excel file
 * @throws Throwable
 */
public static void closeExcel() throws Throwable {
	
	
	wb.close();
	System.out.println("excel closed successfully");
}
}





	
	



