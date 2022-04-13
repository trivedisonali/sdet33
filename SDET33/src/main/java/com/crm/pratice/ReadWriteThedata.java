package com.crm.pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteThedata {

	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
      Workbook wb = WorkbookFactory.create(fis);
     Sheet sh = wb.getSheet("Sdet33");
      Row row = sh.getRow(2);
      //write the data by using set stringcellvalue()
    
   Cell cell = row.createCell(1);
     FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata.xlsx");
       wb.close();
       System.out.println("data is stored");


	}

}
