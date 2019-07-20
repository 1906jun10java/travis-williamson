package com.revature.p1.utilities;

import com.revature.p1.daoimpls.*;

import java.sql.SQLException;

import com.revature.p1.beans.*;
import com.revature.p1.services.*;

public class Driver {

	public static void main(String[] args) {
		//
		
		// Attempt to create a new user
		
		/*
		UserDAOImpl userDaoImpl = new UserDAOImpl();
		
		try {
			userDaoImpl.createUser(0, "Jule", "Smith", "juliesmith", "555 Main St", "Apt 8", "Tampa", "FL", "33601", "juliesmith@company.com", "555-234-0385", 1009);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		// Attempt to retrieve username and password from credentials table
		
		// Works - if username or password is not in database, it returns a
		// single null value
		
		/*
		CredentialsDAOImpl credDAOImpl = new CredentialsDAOImpl();
		
		try {
			System.out.println(credDAOImpl.login("juliesmith", "password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
	}
}
