package com.revature.p1.daos;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.revature.p1.beans.User;

public interface UserDAO {

	public abstract void createUser(int userType, String firstName, String lastName, String username,
			String addressLine1, String addressLine2, String city, String state, String zipCode, String emailAddress,
			String phoneNumber, int managerID) throws SQLException;
	
	public abstract User getUser(String username) throws SQLException;
	
	public abstract List<User> getAllManagedEmployees(int managerID) throws SQLException;
	
	public abstract List<User> getAllEmployeesAndManagers() throws SQLException;
	
	public abstract void updatePersonalInformation(String addressLine1, String addressLine2, String city, 
			String state, String zipCode, String emailAddress, String phoneNumber, int userID) throws SQLException;
	
}
