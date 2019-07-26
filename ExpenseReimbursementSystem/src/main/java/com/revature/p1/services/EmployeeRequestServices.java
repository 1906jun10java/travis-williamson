package com.revature.p1.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;
import com.revature.p1.servlets.*;

public class EmployeeRequestServices {

	// Instance Variables
	
	public RequestDAOImpl requestDAOImpl = new RequestDAOImpl();
	
	// Methods
	
	public void submitRequest(int userID, double amount, int statusID, String requestNote) {
		
		try {
			requestDAOImpl.submitRequest(userID, amount, statusID, requestNote);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Request> viewPendingRequests(int userID) {
		
		List<Request> personalPendingRequests = null;
		
		try {
			personalPendingRequests = requestDAOImpl.viewPendingRequestsForEmployee(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personalPendingRequests;
	}
	
	public List<Request> viewResolvedRequests(int userID) {
		
		List<Request> personalResolvedRequests = null;
		
		try {
			personalResolvedRequests = requestDAOImpl.viewResolvedRequestsForEmployee(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personalResolvedRequests;
	}
}