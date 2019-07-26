package com.revature.p1.beans;

//import java.time.LocalDate;

public class User {

	// Constructors
	
	public User() {
		super();
	}
	
	public User(String username, int userType) {
		this.username = username;
		this.userType = userType;
	}
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(int userID, String firstName, String lastName) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public User(int userID, String firstName, String lastName, int managerID, String managerFirstName, String managerLastName) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerID = managerID;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
	}
	
	public User(int userType, String firstName, String lastName, String username,
			String addressLine1, String addressLine2, String city, String state, String zipCode, String emailAddress,
			String phoneNumber, int managerID) {
		super();
		//this.userID = userID;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.managerID = managerID;
	}
	
	public User(int userID, int userType, String firstName, String lastName, String username,
			String addressLine1, String addressLine2, String city, String state, String zipCode, String emailAddress,
			String phoneNumber, int managerID) {
		super();
		this.userID = userID;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.managerID = managerID;
	}

	// Instance Variables
	
	private int userID;
	private int userType;
	private String firstName;
	private String lastName;
	private String username;
	//private LocalDate birthdate;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String emailAddress;
	private String phoneNumber;
	private int managerID;
	private String managerFirstName;
	private String managerLastName;
	
	// Getters & Setters
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/*
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	*/
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	// Methods

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userType=" + userType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", username=" + username + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", managerID=" + managerID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + managerID;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + userID;
		result = prime * result + userType;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		User other = (User) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (managerID != other.managerID)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (userID != other.userID)
			return false;
		if (userType != other.userType)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
}
