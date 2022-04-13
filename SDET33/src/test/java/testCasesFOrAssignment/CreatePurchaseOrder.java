package testCasesFOrAssignment;

import org.openqa.selenium.WebDriver;

import com.cmr.genericUtility.ConstantPath;
import com.cmr.genericUtility.ExcelUtility;
import com.cmr.genericUtility.FileUtility;
import com.cmr.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrder {

	public static void main(String[] args) throws Throwable {
		String propertiespath = ConstantPath.propertiespath;
		FileUtility.intiallizePropertyFile(propertiespath);
		String url = FileUtility.fetchDataFromProperty("url");
		//String userName = FileUtility.fetchDataFromProperty("userName");
		//String password = FileUtility.fetchDataFromProperty("password");
		 String browser = FileUtility.fetchDataFromProperty("browser");
		 String excelSheet = FileUtility.fetchDataFromProperty("excelSheetName");
		 String excelpath = ConstantPath.Excelpath;
		String timeOuts = FileUtility.fetchDataFromProperty("timeOuts");
		System.out.println(timeOuts);
		long timeOutsLong = Long.parseLong(timeOuts);
		ExcelUtility.openExcel(excelpath);
		ExcelUtility.fetchData(excelSheet, 1, 2);
		
		
		
		//launch the browser
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		}else if (browser.equalsIgnoreCase("firefox")) {
			
		}else

		{
			System.out.println("Browser is not specified properly");
			
		}
WebDriverUtility.maximizeBrowser(driver);
WebDriverUtility.waitforPageload(driver, timeOutsLong);
WebDriverUtility.launchApplicationWithMaximize(driver, url, timeOutsLong);

  //LoginPage lp = new loginpage();
    // lp.loginAction(userName,password);
    // driver.findElement(By.linkText("More")).click();
    // driver.findElement(By.name("purchase order ")).click();

	}






}
