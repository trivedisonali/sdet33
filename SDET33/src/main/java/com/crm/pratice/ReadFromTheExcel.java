
package com.crm.pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromTheExcel {

	public static void main(String[] args) throws IOException {
		//step 1 we should convert the physical file into java readable object
				FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		
				//steps2 open the excel file using "workbook"
				Workbook wb = WorkbookFactory.create(fis);
			   Sheet sh = wb.getSheet("Sdet33");
			   Row row = sh.getRow(1);
			   Cell cell= row.createCell(1);
			   cell.setCellValue("pass");
			  FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata.xlsx");
			  
			wb.write(fos);
			   wb.close();
			   System.out.println("Data is stored in excel");
			   
			}


			

}



