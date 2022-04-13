package com.crm.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rmgyantra {


		public static void main(String[] args) throws SQLException {
			   
		Connection connection =null;String url = null;  String project_id = null; String username = null;String password= null;

		//step:1 we should create the object for the driver and register the driver
			
	   Driver d = new Driver();
	   DriverManager.registerDriver(d);
	   //get connection
	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	   //create statement
	   Statement statement = connection.createStatement();  
	  //execute query
	      int result = statement.executeUpdate("insert into project(project_id,created_by, created_on ,project_name ,status,team_size ) values('ty_proj_009','sonali','11/11/22','sdet33','completed',4)");	  
	      WebDriverManager.chromedriver().setup();
	 	 WebDriver driver = new ChromeDriver();
	 	 driver.get("http://localhost:8084/");
	 	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	 	driver.findElement(By.id ("inputPassword")).sendKeys("rmgy@9999");
	 	driver.findElement(By.xpath("//button [text()='Sign in']")).click();
	 	driver.findElement(By.linkText("Projects"));
	 	
	 	

			
   

}}