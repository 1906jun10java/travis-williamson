package com.revature.p1.beans;

public class Credentials {

	// Constructors
	
	public Credentials() {
		super();
	}
	
	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// Instance Variables

	private int credentialsID;
	private String username;
	private String password;
	private int userID;
	
	// Getters & Setters
	
	public int getCredentialsID() {
		return credentialsID;
	}

	public void setCredentialsID(int credentialsID) {
		this.credentialsID = credentialsID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
		
	// Methods
	
	@Override
	public String toString() {
		return "Credentials [credentialsID=" + credentialsID + ", username=" + username + ", password=" + password
				+ ", userID=" + userID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credentialsID;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (credentialsID != other.credentialsID)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
