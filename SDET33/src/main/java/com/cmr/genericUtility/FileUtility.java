package com.cmr.genericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains only property file common methods
 * @author SONALI TIWARI
 *
 */
public class FileUtility {
	static Properties properties;
	/**
	 * This method is used to fetch the data from property file
	 * @param key
	 * @return
	 */
	public static String fetchDataFromProperty(String key )  {
	
	String value = properties.getProperty(key);
		return value;

	}
	/**
	 * this method is used to intiallize the property file
	 * @param path
	 * @throws IOException
	 */
	public static void intiallizePropertyFile(String path) throws IOException {
		
		FileInputStream fis = new FileInputStream(path);
		properties=new Properties();
		properties.load(fis);
		
		
	}
}
