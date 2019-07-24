package com.revature.p1.daoimpls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public void viewPendingRequestsForEmployee() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void viewResolvedRequestsForEmployee() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void approveRequest() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void denyRequest() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void viewAllPendingRequestsForAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void viewAllResolvedRequestsForAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void viewAllRequestsForEmployee() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
