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
import java.util.List;

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
}
