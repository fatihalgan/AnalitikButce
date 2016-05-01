package com.iztek.abutce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConnectionManager {
	private static final String BUNDLE_NAME = "com.iztek.abutce.config.dbConfig";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private String className = getString("db2driver");
	private String url = getString("url");
	private String username = getString("username");
	private String password = getString("password");
	
	private static ConnectionManager instance = null;
		
	private ConnectionManager() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con= null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager(); 		
		}
		return instance;
	}
	
	private String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}