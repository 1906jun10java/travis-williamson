package com.revature.p1.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.p1.beans.Request;

public interface RequestDAO {

	public abstract void submitRequest(int userID, double amount, int statusID, String requestNote) throws SQLException;
	
	public abstract List<Request> viewPendingRequestsForEmployee(int userID) throws SQLException;
	
	public abstract List<Request> viewResolvedRequestsForEmployee(int userID) throws SQLException;
	
	public abstract void approveRequest(int requestID) throws SQLException;
	
	public abstract void denyRequest(int requestID) throws SQLException;
	
	public abstract List<Request> viewAllPendingRequestsForManagedEmployees(int managerID) throws SQLException;
	
	public abstract List<Request> viewAllResolvedRequestsForAllEmployees() throws SQLException;
	
	public abstract List<Request> viewAllRequestsForEmployee(int userID) throws SQLException;
	
}
