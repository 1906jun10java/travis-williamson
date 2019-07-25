package com.revature.p1.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.p1.beans.*;
import com.revature.p1.daoimpls.*;
import com.revature.p1.servlets.*;

public class ManagerRequestServices {
	
	// Instance Variables
	
	public RequestDAOImpl requestDAOImpl = new RequestDAOImpl();
	
	// Methods
	
	public List<Request> viewAllPendingRequestsForManagedEmployees(int managerID) {
		
		List<Request> allPendingRequestsForManagedEmployee = null;
		
		try {
			allPendingRequestsForManagedEmployee = requestDAOImpl.viewAllPendingRequestsForManagedEmployees(managerID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allPendingRequestsForManagedEmployee;
	}
	
	public static void viewAllResolvedRequests() {
		//
	}
	
	public static void viewAllRequestsFromEmployee() {
		//
	}
	
	public static void approveRequest() {
		//
	}
	
	public static void denyRequest() {
		//
	}
	
	
}
