package com.crm.pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cmr.genericUtility.ExcelUtility;

public class Assert {

@Test(dataProvider="dataprovider_excel")
public void dataprovider_company(String username, String password) {
	System.out.println(username+"==="+password);
}
@DataProvider
public Object[][] dataprovider_company(){
Object [][] arr = new Object[5][2];

arr [0][0] = "TestYantra";
arr [0][0] = 2007;

arr[1][0] = "capgemini";
arr [1] [0] = 2001;

arr [2] [0] = "Ibm";
arr [2][1] = 2001;


 arr [3] [0] = "oracle";
 arr [3][1] = 2002;
 
 arr [4] [0]= "infotech";
 arr [4][1] = 2003;
 return arr;
}
     @DataProvider
public Object[][] dataprovider_excel()throws Throwable{
    	 ExcelUtility.openExcel("./src/test/resources/Sheet1.xlsx");
    	 Object[][] arr = ExcelUtility.fetchMultipleData("Sheet1");
    	 return arr;
     }




		
	
	
	
}
