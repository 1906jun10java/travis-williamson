package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.*;
import com.revature.dao.*;
import com.revature.daoimpl.*;
import com.revature.util.*;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDAOImpl edaoimpl = new EmployeeDAOImpl();
		
		try {
			edaoimpl.insertNewEmployee("Susan", "Young", 1000, 46000, "susanyoung@company.com");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
