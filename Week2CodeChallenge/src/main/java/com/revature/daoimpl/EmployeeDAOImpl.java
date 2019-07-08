package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.*;
import com.revature.beans.*;
import com.revature.util.*;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static ConnFactory cf= ConnFactory.getInstance();
	
	public void insertNewEmployee(String firstName, String lastName,
			int departmentID, double salary, String employeeEmail)
					throws SQLException {
		
		Connection conn= cf.getConnection();
		String sql = "{ call INSERTEMPLOYEE(?)";
		CallableStatement call = conn.prepareCall(sql);
		String sqlStatementString = firstName + ", " + lastName + ", "
				+ departmentID + ", " + salary + ", " + employeeEmail;
		call.setString(1, sqlStatementString);
		//call.setString(1, firstName, lastName, departmentID, 
				//salary, employeeEmail);
		call.execute();
	}
	
}
