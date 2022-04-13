package com.crm.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
@Test
public class SqlExceptionTest {
   
@Test
public void sqlexception() throws SQLException {
		 
			   
		Connection connection =null;

		
		//step:1 we should create the object for the driver and register the driver
			try {
	   Driver driver = new Driver();
	   DriverManager.registerDriver(driver);
	   //get connection
	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet33", "root", "root");
	   
	   //create statement
	   Statement statement = connection.createStatement();
	   
	  //execute query
	 ResultSet result = statement.executeQuery("select * from sdet;");
	 while (result.next()) {
    System.out.println(result.getString(2));
	   

	}

}

finally {
	//steps5: close connection
	connection.close();
	System.out.println("connection is closed");
}
		}
}
		
	
	
	

