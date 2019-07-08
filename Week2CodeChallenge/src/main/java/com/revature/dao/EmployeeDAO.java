package com.revature.dao;

import java.sql.SQLException;

public interface EmployeeDAO {

	public abstract void insertNewEmployee(String firstName, String lastName,
			int departmentID, double salary, String employeeEmail)
		throws SQLException;
	
}
