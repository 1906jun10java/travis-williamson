package com.revature.p1.daoimpls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.p1.beans.Credentials;
import com.revature.p1.daos.CredentialsDAO;
import com.revature.p1.utilities.ConnFactory;

public class CredentialsDAOImpl implements CredentialsDAO {

	// Variables
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	// Methods
	
	public Credentials login(String username, String password) throws SQLException {
		
		//boolean result = false;
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		//ResultSet rs = stmt.executeQuery("SELECT * FROM P1_CREDENTIALS WHERE USERNAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		ResultSet rs = stmt.executeQuery("SELECT P1_CREDENTIALS.USERNAME, USER_PASSWORD, USER_TYPE "
				+ "FROM P1_USER JOIN P1_CREDENTIALS ON P1_USER.USERNAME = P1_CREDENTIALS.USERNAME "
				+ "WHERE P1_CREDENTIALS.USERNAME = "+"'"+username+"' AND P1_CREDENTIALS.USER_PASSWORD = "+"'"+password+"'" );
		Credentials databaseCredentials = null;
		
		while(rs.next()) {
			databaseCredentials = new Credentials (rs.getString(1), rs.getString(2), rs.getInt(3));
		}
		
		return databaseCredentials;
		
		// if username or password is not in database, it returns a single null value

	}
	
	public void logout() throws SQLException {
		//
	}
}
