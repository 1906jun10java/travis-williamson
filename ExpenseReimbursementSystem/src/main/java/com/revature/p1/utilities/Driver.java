package com.revature.p1.utilities;

import com.revature.p1.daoimpls.*;

import java.sql.SQLException;

import com.revature.p1.beans.*;
import com.revature.p1.services.*;

public class Driver {

	public static void main(String[] args) {
		
		// Instance variables for testing purposes:
		
		UserDAOImpl userDaoImpl = new UserDAOImpl();
		
		CredentialsDAOImpl credDAOImpl = new CredentialsDAOImpl();
		
		// Attempt to create a new user
		
		/*
		
		
		try {
			userDaoImpl.createUser(2, "Julie", "Smith", "juliesmith", "555 Main St", "Apt 8", "Tampa", "FL", "33601", "juliesmith@company.com", "555-234-0385", 1009);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		// Attempt to retrieve username and password from credentials table
		
			// Works - if username or password is not in database, it returns a
			// single null value
		
		/*
		
		try {
			Credentials databaseCreds = credDAOImpl.login("bobsmith", "password");
			System.out.println(databaseCreds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
		// Test to see what is printed out when a User is null
		
		/*
		User u = null;
		
		System.out.println(u);
		*/
		
		// Attempt to retrieve user by username from user table
		
		try {
			User u = userDaoImpl.getUser("janicejones");
			System.out.println(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
