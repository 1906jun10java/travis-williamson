package com.revature.p1.utilities;

import java.io.FileNotFoundException;  
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	//Singleton Factory
		private static ConnFactory cf= new ConnFactory();
		//constructor
		private ConnFactory() {
			super();
		}
		public static synchronized ConnFactory getInstance() {
			if(cf==null) {
				cf= new ConnFactory();
			}
			return cf;
		}
		public Connection getConnection(String filename) throws SQLException, FileNotFoundException, IOException {
			Connection conn =null;
			Properties prop = new Properties();
			
			try {
				InputStream in = getClass().getClassLoader().getResourceAsStream(filename);
				prop.load(in);
				Class.forName(prop.getProperty("driver"));
				
				conn= DriverManager.getConnection(
						prop.getProperty("url"), 
						prop.getProperty("usr"),
						prop.getProperty("password"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	}