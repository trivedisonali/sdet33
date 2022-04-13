package com.cmr.genericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public HomePage homepage;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smoke","regression"})
	public void openDatabase() throws Throwable {
		FileUtility.intiallizePropertyFile(ConstantPath.propertiespath);
		ExcelUtility.openExcel(ConstantPath.Excelpath);
	//DatabaseUtility.getMysqlDatabaseConnection(ConstantPath.dbUrl, FileUtility.fetchDataFromProperty("dbUserName"), 
		//FileUtility.fetchDataFromProperty("dbPassword"));		
	}
	
	//@Parameters(value="browser")
	
	@BeforeClass(groups={"smoke","regression"})
	//String browser
	//public void launchBrowser(String browser ) {
		public void launchBrowser() {
		long timeout = JavaUtility.convertStringToLong(FileUtility.fetchDataFromProperty("timeouts"));
		//String browser = FileUtility.fetchDataFromProperty("browser");
		String browser = System.getProperty("browser");
		//String browser = FileUtility.fetchDataFromProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		else {
		Reporter.log("browser is not specify",true);
			
		}
	 String url = System.getProperty("url");
		WebDriverUtility.launchApplicationWithMaximize(driver, url, timeout);//FileUtility.fetchDataFromProperty("url")
		sdriver=driver;
	}
	
	@BeforeMethod(groups={"smoke","regression"})
	public void loginToApplication() throws Throwable {
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.ToLogin(FileUtility.fetchDataFromProperty("username"), FileUtility.fetchDataFromProperty("password"));
		  homepage = new HomePage(driver);
		
	}
		 @AfterMethod(groups={"smoke","regression"})
		 public void logoutFromApplication() throws Throwable {
			 homepage.Logout(driver);
			 ExcelUtility.closeExcel(); 
		 }
		 
		 @AfterClass
		 public void closeBrowser() {
			 WebDriverUtility.closeBrowser(driver);
		 }
		 
		 @AfterSuite(groups={"smoke","regression"})
		 public void closeDBConnection() throws SQLException {
			// DatabaseUtility.closeDatabaseConnection();
		 }
}