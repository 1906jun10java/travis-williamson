package com.revature.p1.daoimpls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.p1.beans.Request;
import com.revature.p1.beans.User;
import com.revature.p1.daos.RequestDAO;
import com.revature.p1.utilities.ConnFactory;

public class RequestDAOImpl implements RequestDAO {

	// Variables
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	// Methods
	
	public void submitRequest(int userID, double amount, int statusID, String requestNote) throws SQLException {
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO P1_REQUEST VALUES(SQ_REQUEST_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ps.setDouble(2, amount);
		ps.setInt(3, statusID);
		ps.setString(4, requestNote);
		ps.executeUpdate();
	}

	public List<Request> viewPendingRequestsForEmployee(int userID) throws SQLException {
		
		List<Request> pendingRequestsForEmployee = new ArrayList<Request>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT RS.STATUS_TYPE_NAME, R.REQUEST_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_ID, R.AMOUNT " +  
				"FROM P1_REQUEST_STATUS_TYPE RS, P1_REQUEST R, P1_USER U " + 
				"WHERE RS.STATUS_TYPE_ID = R.STATUS_TYPE_ID AND R.USER_ID = U.USER_ID " + 
				"AND R.STATUS_TYPE_ID = 0 AND U.USER_ID = "+"'"+userID+"'");
		
		while (rs.next()) {
			Request request = new Request(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6));
			pendingRequestsForEmployee.add(request);
		}				
		
		return pendingRequestsForEmployee;
		
	}

	public List<Request> viewResolvedRequestsForEmployee(int userID) throws SQLException {
		
		List<Request> resolvedRequestsForEmployee = new ArrayList<Request>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT RS.STATUS_TYPE_NAME, R.REQUEST_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_ID, R.AMOUNT " +  
				"FROM P1_REQUEST_STATUS_TYPE RS, P1_REQUEST R, P1_USER U " + 
				"WHERE RS.STATUS_TYPE_ID = R.STATUS_TYPE_ID AND R.USER_ID = U.USER_ID " + 
				"AND (R.STATUS_TYPE_ID = 1 OR R.STATUS_TYPE_ID = 2) AND U.USER_ID = "+"'"+userID+"'");
		
		while (rs.next()) {
			Request request = new Request(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6));
			resolvedRequestsForEmployee.add(request);
		}								
		
		return resolvedRequestsForEmployee;
		
	}

	public void approveRequest(int requestID) throws SQLException {
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE P1_REQUEST SET STATUS_TYPE_ID = 1 WHERE REQUEST_ID = "+"'"+requestID+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
	}

	public void denyRequest(int requestID) throws SQLException {
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = "UPDATE P1_REQUEST SET STATUS_TYPE_ID = 2 WHERE REQUEST_ID = "+"'"+requestID+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
	}

	public List<Request> viewAllPendingRequestsForManagedEmployees(int managerID) throws SQLException {
		
		List<Request> allPendingRequests = new ArrayList<Request>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT REQUEST_ID, P1_REQUEST.USER_ID, AMOUNT, STATUS_TYPE_ID, NOTE, FIRST_NAME, LAST_NAME " + 
				"FROM P1_REQUEST INNER JOIN P1_USER ON P1_USER.USER_ID = P1_REQUEST.USER_ID " + 
				"WHERE STATUS_TYPE_ID = 0 AND MANAGER_ID = "+"'"+managerID+"'");
		
		while (rs.next()) {
			Request request = new Request(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
			allPendingRequests.add(request);
		}
		
		return allPendingRequests;
		
	}

	public List<Request> viewAllResolvedRequestsForAllEmployees() throws SQLException {
		
		List<Request> allResolvedRequests = new ArrayList<Request>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT RS.STATUS_TYPE_NAME, R.REQUEST_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_ID, R.AMOUNT, " + 
				"U.MANAGER_ID, M.FIRST_NAME, M.LAST_NAME " + 
				"FROM P1_REQUEST_STATUS_TYPE RS, P1_REQUEST R, P1_USER U, P1_USER M " + 
				"WHERE RS.STATUS_TYPE_ID = R.STATUS_TYPE_ID AND R.USER_ID = U.USER_ID AND U.MANAGER_ID = M.USER_ID " + 
				"AND (R.STATUS_TYPE_ID = 1 OR R.STATUS_TYPE_ID = 2)");
		
		while (rs.next()) {
			Request request = new Request(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getString(9));
			allResolvedRequests.add(request);
		}
		
		return allResolvedRequests;
		
	}

	public List<Request> viewAllRequestsForEmployee(int userID) throws SQLException {
		
		List<Request> allRequestsForEmployee = new ArrayList<Request>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT RS.STATUS_TYPE_NAME, R.REQUEST_ID, U.FIRST_NAME, U.LAST_NAME, U.USER_ID, R.AMOUNT " + 
				"FROM P1_REQUEST_STATUS_TYPE RS, P1_REQUEST R, P1_USER U " + 
				"WHERE RS.STATUS_TYPE_ID = R.STATUS_TYPE_ID AND R.USER_ID = U.USER_ID AND U.USER_ID = "+"'"+userID+"'" );
		
		while (rs.next()) {
			Request request = new Request(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			allRequestsForEmployee.add(request);
		}		
		
		
		return allRequestsForEmployee;
		
	}
	
}
