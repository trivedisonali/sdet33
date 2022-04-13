package com.Crm.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmr.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactandOraganization {

//private static final WebElement typeListBox = null;

static  String OrganizationPageUrlFraction = null;

	public static void main(String[] args)throws IOException {
		WebDriver driver = null;
		 FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	 Properties properties =  new Properties();
	 properties.load(fis);
	// String url = properties.getProperty("url");
	 String username= properties.getProperty("username"); 
	 String password  = properties.getProperty("password");
	 String browser = properties.getProperty("browser");
	 String timeOut = properties.getProperty("timeOut");
			 long timeOuts = Long.parseLong(timeOut);
			 String homepageUrlFraction= properties.getProperty("homepageUrlfraction");
			 String organizationName = "testyantra";
			 
			 if (browser.equalsIgnoreCase("chrome")) {
				 WebDriverManager.chromedriver().setup();
				 driver= new ChromeDriver();
				 
			 }

	else if (browser.equalsIgnoreCase("Firefox")) {
				 WebDriverManager.firefoxdriver().setup();
				  driver = new FirefoxDriver();
				 
				  
	} else {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,timeOuts);
	//	driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		
		
		driver.findElement(By.name("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt= 'Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("RMG4");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	//WebElement industryListBox = driver.findElement(By.name("industry"));
	//WebElement typeListBox= driver.findElement(By.name("accounttype"));
	
	//WebDriverUtility.select(industryListBox, Industy);
	//Select selectIndustyListBox = new Select(industryListBox);
	//selectIndustyListBox.selectByVisibleText(industry);
	
	//Select selectTypeListBox = new Select(typeListBox);
	
	driver.findElement(By.cssSelector("input[@title='Save [Alt+S]']")).click();
	wait.until(ExpectedConditions.urlContains("urlFraction"));
	
	WebElement organizationTF= driver.findElement(By.xpath("//td[text()=OrganizationName']following-sibling::td/span"));
	
				if (organizationTF.getText().contains("RMG4")) {
		System.out.println("pass:Oraganization name entered");
	}
	else {
		System.out.println("fail: Organization name not enterted");
	}
	Actions action = new Actions(driver); 
	WebElement logoutLogo= driver.findElement(By.xpath("//span[text()='Administractor']/..following-sibling::td/img)[1]"));
	//WebElement ele1 = driver.findElement(By.cssSelector("span[id ='dt]veiw_Oraganization Name']"));
	action.moveToElement(logoutLogo).perform();
	driver.findElement(By.xpath("//a [text()=Sign Out']")).click();
      WebDriverUtility.closeBrowser(driver);
	driver.quit();
	}


		
	}

	

	
		
		
	 
		
	

