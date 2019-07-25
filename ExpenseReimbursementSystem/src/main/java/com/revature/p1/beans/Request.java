package com.revature.p1.beans;

public class Request {

	// Constructors
	
	public Request() {
		super();
	}
	
	public Request(int requestID, int userID, double amount, int statusID, String requestNote) {
		super();
		this.requestID = requestID;
		this.userID = userID;
		this.amount = amount;
		this.statusID = statusID;
		this.requestNote = requestNote;
	}
	
	public Request(int requestID, int userID, double amount, int statusID) {
		super();
		this.requestID = requestID;
		this.userID = userID;
		this.amount = amount;
		this.statusID = statusID;
	}
	
	public Request(String requestStatusType, int requestID, String requesterFirstName, String requesterLastName,
			int userID, double amount) {
		
		this.requestStatusType = requestStatusType;
		this.requestID = requestID;
		this.requesterFirstName = requesterFirstName;
		this.requesterLastName = requesterLastName;
		this.userID = userID;
		this.amount = amount;
	}
	
	public Request(int requestID, int userID, double amount, int statusID, String requestNote,
			String requesterFirstName, String requesterLastName) {
		super();
		this.requestID = requestID;
		this.userID = userID;
		this.amount = amount;
		this.statusID = statusID;
		this.requestNote = requestNote;
		this.requesterFirstName = requesterFirstName;
		this.requesterLastName = requesterLastName;
	}

	// Instance Variables
	
	private int requestID;
	private int userID;
	private double amount;
	private int statusID;
	private String requestNote;
	private String requesterFirstName;
	private String requesterLastName;
	private String requestStatusType;
	
	// Getters & Setters
	
	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getRequestNote() {
		return requestNote;
	}

	public void setRequestNote(String requestNote) {
		this.requestNote = requestNote;
	}

	public String getRequesterFirstName() {
		return requesterFirstName;
	}

	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}

	public String getRequesterLastName() {
		return requesterLastName;
	}

	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}

	public String getRequestStatusType() {
		return requestStatusType;
	}

	public void setRequestStatusType(String requestStatusType) {
		this.requestStatusType = requestStatusType;
	}

	// Methods
	
	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", userID=" + userID + ", amount=" + amount + ", statusID="
				+ statusID + ", requestNote=" + requestNote + ", requesterFirstName=" + requesterFirstName
				+ ", requesterLastName=" + requesterLastName + ", requestStatusType=" + requestStatusType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + requestID;
		result = prime * result + ((requestNote == null) ? 0 : requestNote.hashCode());
		result = prime * result + ((requestStatusType == null) ? 0 : requestStatusType.hashCode());
		result = prime * result + ((requesterFirstName == null) ? 0 : requesterFirstName.hashCode());
		result = prime * result + ((requesterLastName == null) ? 0 : requesterLastName.hashCode());
		result = prime * result + statusID;
		result = prime * result + userID;
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
		Request other = (Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (requestID != other.requestID)
			return false;
		if (requestNote == null) {
			if (other.requestNote != null)
				return false;
		} else if (!requestNote.equals(other.requestNote))
			return false;
		if (requestStatusType == null) {
			if (other.requestStatusType != null)
				return false;
		} else if (!requestStatusType.equals(other.requestStatusType))
			return false;
		if (requesterFirstName == null) {
			if (other.requesterFirstName != null)
				return false;
		} else if (!requesterFirstName.equals(other.requesterFirstName))
			return false;
		if (requesterLastName == null) {
			if (other.requesterLastName != null)
				return false;
		} else if (!requesterLastName.equals(other.requesterLastName))
			return false;
		if (statusID != other.statusID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	
	
	
		
	
	
	
	
}
