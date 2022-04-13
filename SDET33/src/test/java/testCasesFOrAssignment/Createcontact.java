package testCasesFOrAssignment;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cmr.genericUtility.ConstantPath;
import com.cmr.genericUtility.FileUtility;
import com.cmr.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createcontact {
	
	static WebDriver driver1;

	public static void main (String []args) throws Throwable {
		
	}
	//to fetch property file
		String propertiesfilepath = ConstantPath.propertiespath;
		
		String url = FileUtility.fetchDataFromProperty("url");	
	String username = FileUtility.fetchDataFromProperty("userName");
	String password = FileUtility.fetchDataFromProperty("password");
	String browser = FileUtility.fetchDataFromProperty("browser");
	String excelsheetname = FileUtility.fetchDataFromProperty("excelsheetname");
	String timeOuts = FileUtility.fetchDataFromProperty("timeOuts"); 
	
long timeOutLong= Long.parseLong(timeOuts);
	
	//generate random number 
	Random  ran = new Random();
   // to fetch data from excel
	
	//String contname = ExcelUtility.fetchData(excelsheetname, 1, 2);	{
	//create random number
  // JavaUtility. generateRandomNumber(2000);
		
	//ExcelUtility.openExcel(excelsheetname);	
// String contactName=ExcelUtility.fetchData(excelsheetname, 1, 2);
	 
//launch the browser
	WebDriver driver = null;
	{
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver1= new ChromeDriver();
	}
		
	

	else {  if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver1= new FirefoxDriver();
	}
	else {
		
		System.out.println("browser is  not specified");
	}

	
	//basic configuration
	WebDriverUtility.launchApplicationWithMaximize(driver1, url, timeOutLong);
	
	//login to application
	//LoginPage lp = new LoginPage(driver);
	//lp.enterUN_PWD(username, password);
	//driver1.findElement(By.name("user_name")).sendKeys(username);
   //driver1.findElement(By.name("user_password")).sendKeys(password); 
   // driver1.findElement(By.id("submitButton")).click();
	
	
    //create contact
    driver1.findElement(By.xpath("//a[text()='Contacts']")).click();
    driver1.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    
    //driver1.findElement(By.name("lastname")).sendKeys(contname);
    driver1.findElement(By.xpath("//input[@title='Save [Alt+S]'])")).click();
    
    //logout from application
     WebElement ele = driver1.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 WebDriverUtility.moveToElement(driver1, ele);
	 driver1.findElement(By.linkText("Sign Out")).click();
	 // create organization

     
}
	}
	
	
	
}

