package com.revature.p1.services;

import java.sql.SQLException;

import org.apache.logging.log4j.*;

import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;
import com.revature.p1.servlets.*;

public class CredentialsServices {
	
	// Instance Variables
	
	static Logger log = LogManager.getLogger(CredentialsServices.class);
	
	// Methods
	
	public User authenticateUser(Credentials creds) {
		
		// Get the typed-in credentials information from the user
		
		String typedUsername = creds.getUsername();
		String typedPassword = creds.getPassword();
		
		// Check to see if that info matches what's in the database
		
		CredentialsDAOImpl credDAOImpl = new CredentialsDAOImpl();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User u = null;
		
		try {
			Credentials databaseCreds = credDAOImpl.login(typedUsername, typedPassword);
			
			if(typedUsername.equals(databaseCreds.getUsername()) && typedPassword.equals(databaseCreds.getPassword())) {
				
				u = userDAOImpl.getUser(databaseCreds.getUsername());
			}
			
			
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			log.error("Invalid credentials");
			e.printStackTrace();
		}
		
		return u;
	}

}
