package com.revature.p1.daoimpls;

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
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM P1_CREDENTIALS WHERE USERNAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		Credentials databaseCredentials = null;
		
		while(rs.next()) {
			databaseCredentials = new Credentials (rs.getString(1), rs.getString(2));
		}
		
		return databaseCredentials;
	}
	
	public void logout() throws SQLException {
		//
	}
}
