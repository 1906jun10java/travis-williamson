package com.revature.p1.daoimpls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.p1.beans.*;
import com.revature.p1.daos.UserDAO;
import com.revature.p1.utilities.ConnFactory;

public class UserDAOImpl implements UserDAO {

	// Variables
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	// Methods
	
	public void createUser(int userType, String firstName, String lastName, String username, 
			String addressLine1, String addressLine2, String city, String state, String zipCode, String emailAddress,
			String phoneNumber, int managerID) throws SQLException {
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO P1_USER VALUES(SQ_USER_PK.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userType);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, username);
		ps.setString(5, addressLine1);
		ps.setString(6, addressLine2);
		ps.setString(7, city);
		ps.setString(8, state);
		ps.setString(9, zipCode);
		ps.setString(10, emailAddress);
		ps.setString(11, phoneNumber);
		ps.setInt(12, managerID);
		ps.executeUpdate();
	}
	
	public User getUser(String username) throws SQLException {
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM P1_USER WHERE USERNAME = "+"'"+username+"'" );
		User u = null;
		
		while(rs.next()) {
			u = new User (rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
					rs.getString(12), rs.getInt(13));
		}
		
		return u;
	}
	
	public List<User> getAllManagedEmployees(int managerID) throws SQLException {
		
		List<User> allManagedEmployees = new ArrayList<User>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT USER_ID, FIRST_NAME, LAST_NAME FROM P1_USER WHERE MANAGER_ID = "+"'"+managerID+"'");
		
		while (rs.next()) {
			User employee = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			allManagedEmployees.add(employee);
		}
		
		return allManagedEmployees;
	}
	
	public List<User> getAllEmployeesAndManagers() throws SQLException {
		
		List<User> employeeAndManager = new ArrayList<User>();
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT e.USER_ID, e.FIRST_NAME, e.LAST_NAME, m.USER_ID, m.FIRST_NAME, m.LAST_NAME " +
			"FROM P1_USER e LEFT JOIN P1_USER m ON m.USER_ID = e.MANAGER_ID ORDER BY e.MANAGER_ID");
		
		while (rs.next()) {
			User employee = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			employeeAndManager.add(employee);
		}
		
		return employeeAndManager;
	}
	
	public void updatePersonalInformation(String addressLine1, String addressLine2, String city, String state, String zipCode, 
			String emailAddress, String phoneNumber, int userID) throws SQLException {
		
		Connection conn = null;
		try {
			conn = cf.getConnection("database.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE P1_USER SET ADDRESS_LINE_1 = ?, ADDRESS_LINE_2 = ?, CITY = ?, STATE_ABRV = ?, ZIP_CODE = ?, " 
		    + "EMAIL = ?, PHONE = ? WHERE USER_ID = "+"'"+userID+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, addressLine1);
		ps.setString(2, addressLine2);
		ps.setString(3, city);
		ps.setString(4, state);
		ps.setString(5, zipCode);
		ps.setString(6, emailAddress);
		ps.setString(7, phoneNumber);
		ps.executeUpdate();
	}
}
