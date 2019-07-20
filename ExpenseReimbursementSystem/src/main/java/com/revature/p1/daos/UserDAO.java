package com.revature.p1.daos;

import java.sql.SQLException;
import java.time.LocalDate;

public interface UserDAO {

	public abstract void createUser(int userType, String firstName, String lastName, String username,
			String addressLine1, String addressLine2, String city, String state, String zipCode, String emailAddress,
			String phoneNumber, int managerID) throws SQLException;
	
}
