package com.revature.p1.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.revature.p1.beans.*;

public interface CredentialsDAO {

	public Credentials login(String username, String password) throws SQLException;
	
}
