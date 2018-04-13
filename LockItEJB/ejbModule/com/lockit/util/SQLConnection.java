package com.lockit.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	
	private static SQLConnection sqlConnectionObject = null;
	private Connection connection = null;
	
	private SQLConnection() {
		
	}
	
	public static SQLConnection getInstance() {
		if(sqlConnectionObject == null) {
			sqlConnectionObject = new SQLConnection();
		}
		return sqlConnectionObject;
	}
	
	public Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/";
		String dbname = "claivoradb";
		String username = "root";
		String password = "spectrum";
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url + dbname, username, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return connection;
	}
}
