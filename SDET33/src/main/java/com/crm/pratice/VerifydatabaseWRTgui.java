package com.crm.pratice;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifydatabaseWRTgui {

	public static void main(String[] args) throws IOException, SQLException {
		Connection connection = null;
		
		try {
			Driver d = new Driver(); 
			
			   DriverManager.registerDriver(d);
			   //get connection
			   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
			   //create the property
			   Properties properties = new Properties();
			   properties.load(fis);
			String url = properties.getProperty("url");
			   System.out.println(url);
			   
			   String username = properties.getProperty("userName");
			   System.out.println(username);
			   
			   String password = properties.getProperty("password");
			   System.out.println(password);
			   
			   String browser = properties.getProperty("browser");  
			   System.out.println(browser);
			   String timeOuts= properties.getProperty("timeOuts");
			System.out.println(timeOuts);
			long  timeoutLong = Long.parseLong(timeOuts);
			   WebDriver driver = null;  
			   if (browser.equalsIgnoreCase("chrome"))
			   {
				   WebDriverManager.chromedriver().setup();
				   driver= new ChromeDriver();
			   }
			   else if (browser.equalsIgnoreCase("firefox"))
			   {
				   WebDriverManager.firefoxdriver().setup();
				  driver = new FirefoxDriver();
			   }
			   else { System.out.println("browser is not specified property");
			   }
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(timeoutLong,TimeUnit.SECONDS);
			 	 driver.get("http://localhost:8084/");
				 	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				 	driver.findElement(By.id ("inputPassword")).sendKeys("rmgy@9999");
				 	driver.findElement(By.xpath("//button [text()='Sign in']")).click();
				 	driver.findElement(By.linkText("Projects")).click();
				 	driver.findElement(By.xpath("//span[text()='Create project']")).click();
				 	String projname = "TY_Proj004";
				 	driver.findElement(By.name("projname")).sendKeys("testyantra");
				 	driver.findElement(By.name("createdBy")).sendKeys("Mohan");
				 	WebElement dropdown = driver.findElement(By.xpath("//label[.='project status']/following sibling ::select"));
				 	
				    Select select = new Select(dropdown);
				select.selectByVisibleText("completed");
				driver.findElement(By.xpath("//input[@value= 'Add project']")).click();
				
				Statement statement = connection.createStatement();
				//execute the query
				ResultSet result = statement.executeQuery("select*from project;");
				while(result.next())
				{
				
						String projectName = result.getString("project_name");//project_name from database
						if (projectName.equalsIgnoreCase(projectName)) {
							System.out.println("data is stored in database");
						}		
					}
					driver.close();
		} 
  
				finally { 
					connection.close();
					System.out.println("connection is closed");
				}
				
		
	}

				
			   
				 

		
				 	

				 
			   
}


		
