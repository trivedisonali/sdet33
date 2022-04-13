package com.crm.pratice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
          Sheet sh= wb.getSheet("Login");
          for (int i = 1; i<=sh.getLastRowNum();i++) {
        	  Row row = sh.getRow(i);
        	  for (int j= 0;j<row.getLastCellNum();j++ )
        	  {
        	  String userNamePassword= sh.getRow(i).getCell(j).toString();
        	  String password = sh.getRow(i).getCell(1).getStringCellValue();
        	  System.out.println(userNamePassword+"\n");
          }
          }
	}

}
