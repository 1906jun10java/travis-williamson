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
	
	public List<Request> viewAllResolvedRequests() {
		
		List<Request> allResolvedRequestsForAllEmployees = null;
		
		try {
			allResolvedRequestsForAllEmployees = requestDAOImpl.viewAllResolvedRequestsForAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allResolvedRequestsForAllEmployees;
	}
	
	public List<Request> viewAllRequestsFromEmployee(int userID) {
		//
		List<Request> allRequestsForManagedEmployee = null;
		
		try {
			allRequestsForManagedEmployee = requestDAOImpl.viewAllRequestsForEmployee(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allRequestsForManagedEmployee;
	}
	
	public void approveRequest(int requestID) {
		
		try {
			requestDAOImpl.approveRequest(requestID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void denyRequest(int requestID) {
		
		try {
			requestDAOImpl.denyRequest(requestID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
