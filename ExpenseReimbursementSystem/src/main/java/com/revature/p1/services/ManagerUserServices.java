package com.revature.p1.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;
import com.revature.p1.servlets.*;

public class ManagerUserServices {
	
	// Instance Variables
	
	private UserDAOImpl userDAOImpl = new UserDAOImpl();
	
	// Methods
	
	public List<User> viewAllEmployeesAndManagers() {
		
		List<User> employeesAndManagers = null;
		
		try {
			employeesAndManagers = userDAOImpl.getAllEmployeesAndManagers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeesAndManagers;
	}
	
	public User viewPersonalInformation(String username) {
		User user = null;
		
		try {
			user = userDAOImpl.getUser(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void updatePersonalInformation(String addressLine1, String addressLine2, String city, String state, 
			String zipCode, String emailAddress, String phoneNumber, int userID) {
		
		try {
			userDAOImpl.updatePersonalInformation(addressLine1, addressLine2, city, state, zipCode, 
					emailAddress, phoneNumber, userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
