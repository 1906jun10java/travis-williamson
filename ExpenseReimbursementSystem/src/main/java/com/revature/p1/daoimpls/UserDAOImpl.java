package com.revature.p1.daoimpls;

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
		
		Connection conn = cf.getConnection();
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
}
