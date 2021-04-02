package com.crm.Rosava.Generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con = null;
	ResultSet result = null;

	/**
	 * to connect to DataBase
	 * 
	 * 
	 */
	public  void connectToDB() throws Throwable 
	{
		
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "root");
		
	}
	
	/**
	 * to close DataBase connection
	 * 
	 * 
	 */
	public  void closeDb() throws SQLException 
	{
	con.close();
	}
	

	/**
	 * to executive query to fetch data from DB
	 * 
	 * @param query
	 * 
	 */
	public ResultSet executeQuery(String query) throws Throwable 
	{
	
	result = con.createStatement().executeQuery(query);
	return result;
		
	}
}
