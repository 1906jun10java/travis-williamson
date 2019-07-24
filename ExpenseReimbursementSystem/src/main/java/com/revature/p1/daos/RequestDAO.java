package com.revature.p1.daos;

import java.sql.SQLException;

public interface RequestDAO {

	public abstract void submitRequest(int userID, double amount, int statusID, String requestNote) throws SQLException;
	
	public abstract void viewPendingRequestsForEmployee() throws SQLException;
	
	public abstract void viewResolvedRequestsForEmployee() throws SQLException;
	
	public abstract void approveRequest() throws SQLException;
	
	public abstract void denyRequest() throws SQLException;
	
	public abstract void viewAllPendingRequestsForAllEmployees() throws SQLException;
	
	public abstract void viewAllResolvedRequestsForAllEmployees() throws SQLException;
	
	public abstract void viewAllRequestsForEmployee() throws SQLException;
	
}
