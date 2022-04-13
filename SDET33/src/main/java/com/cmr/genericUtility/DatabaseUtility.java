package com.cmr.genericUtility;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

	/**
	 *This class contains all th generic 
	 * @author SONALI TIWARI
	 *
	 */
	public class DatabaseUtility {


		static  Connection Connection;

		static ArrayList<String> List = new ArrayList<String>();

		/**
		 *  This method is used to establish the connection of Mysql database
		 * @param dbUrl
		 * @param dbUserName
		 * @param dbPassword
		 * @throws SQLException
		 */
		public static void getMysqlDatabaseConnection(String dbUrl, String dbUserName, String dbPassword) throws SQLException  {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}
		/**
		 * This method is used to fetch the data from database based on the column number
		 * @param query
		 * @param columnNumber
		 * @return
		 * @throws SQLException
		 */

		public static ArrayList<String>  getDataFromDatabase(String query, int columnNumber) throws SQLException {

			Statement statement = Connection.createStatement();


			ResultSet result = statement.executeQuery(query);


			while (result.next()) {

				List.add(result.getString(columnNumber));


			}
			statement.close();
			return List;
		}
		/**
		 * This method is used to fetch the data from database based on the column name
		 * @param query
		 * @param ColumnNameOrcolumnNumber
		 * @return
		 * @throws SQLException
		 */
		public static ArrayList<String> getDataFromDatabase(String query, String ColumnNameOrcolumnNumber)throws SQLException {

			//if we wont use Arraylist we get only last data, in arraylist we get set of data(if we use 
			String num="";
			for (int i = 0; i < ColumnNameOrcolumnNumber.length(); i++) {

				char ch = ColumnNameOrcolumnNumber.charAt(i);
				if (Character.isDigit(ch)) {
					num=num+ColumnNameOrcolumnNumber.charAt(i);

				} else {
					break;

				}

			}
			Statement statement = Connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			int columnNumber = 0;
			String ColumnName = null;
			if (num.equalsIgnoreCase(ColumnNameOrcolumnNumber)) {
				columnNumber=Integer.parseInt(num);
				while (result.next()) {
					List.add(result.getString(columnNumber));
				}
			}
			else {
				ColumnName=ColumnNameOrcolumnNumber;
				while (result.next()) {
					List.add(result.getString(columnNumber));

				}
			}

			statement.close();
			return List;

		}

		/**
		 * This method is used to update/write/modify the data into the databse
		 * @param query
		 * @throws SQLException
		 */
		public static void updateDatabaseIntoDatabase(String query) throws SQLException {

			Statement statement = Connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			System.out.println("Query executed successfully");
			statement.close();

		}
		/**
		 * This is method is used to close the database connection
		 * @throws SQLException
		 */
		public static void closeDatabaseConnection() throws SQLException {

			Connection.close();
		}
		/**
		 * This method is used to verify the data wheather it is present in the database or not
		 * @param query
		 * @param ColumnNameOrcolumnNumber
		 * @param expData
		 * @return
		 * @throws SQLException
		 */
		public static boolean verifyData(String query, String ColumnNameOrcolumnNumber, String expData) throws SQLException {

			ArrayList<String> listData = getDataFromDatabase( query, ColumnNameOrcolumnNumber);

			boolean flag=false;
			for (String data :listData) {
				if (data.equalsIgnoreCase(expData)) {
					flag=true;
					break;
				}			
			}

			return flag;
		}

	
	}


