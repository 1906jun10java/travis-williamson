package com.revature.p1.services;

import java.sql.SQLException;

import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;
import com.revature.p1.servlets.*;

public class CredentialsServices {
	
	// Instance Variables
	
	
	
	// Methods
	
	public User authenticateUser(Credentials creds) {
		
		// Get the typed-in credentials information from the user
		
		String typedUsername = creds.getUsername();
		String typedPassword = creds.getPassword();
		
		// Check to see if that info matches what's in the database
		
		CredentialsDAOImpl credDAOImpl = new CredentialsDAOImpl();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		//Credentials databaseCreds = null;
		User u = null;
		
		try {
			Credentials databaseCreds = credDAOImpl.login(typedUsername, typedPassword);
			
			//u = new User(databaseCreds.getUsername(), databaseCreds.getUserType());
			
			
			if(typedUsername.equals(databaseCreds.getUsername()) && typedPassword.equals(databaseCreds.getPassword())) {
				//u = new User(databaseCreds.getUsername(), databaseCreds.getUserType());
				u = userDAOImpl.getUser(databaseCreds.getUsername());
			}
			
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public static void login() {
		//
		
	}
	
	public static void logout() {
		//
	}

}
