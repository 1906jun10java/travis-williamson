package com.revature.p1.daos;

import java.sql.SQLException;

public interface ReceiptDAO {

	public abstract void uploadReceipt() throws SQLException;
	
	public abstract void getAllReceipts() throws SQLException;
	
}
