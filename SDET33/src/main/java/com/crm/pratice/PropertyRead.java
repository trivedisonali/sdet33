package com.crm.pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PropertyRead {
//@BeforeSuite (groups = "smoke,Regression")
	public static void main(String[] args) throws IOException {
		//step:1convert the physical file into java readable object
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		
	//STEP2 create the object of properties
	Properties properties = new Properties();
	
	//STep3: load all the keys
properties.load(fis);
// fetch the data
   String url = properties.getProperty("url");
	System.out.println(url);

	}

}
