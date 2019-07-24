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

}
