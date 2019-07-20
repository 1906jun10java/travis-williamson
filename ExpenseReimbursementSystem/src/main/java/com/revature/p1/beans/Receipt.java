package com.revature.p1.beans;

//import org.apache.tomcat.jni.File;

import java.io.File;

public class Receipt {

	// Constructors
	
	public Receipt() {
		super();
	}
	
	public Receipt(int receiptID, File imageFile, int requestID, String receiptNote) {
		super();
		this.receiptID = receiptID;
		this.imageFile = imageFile;
		this.requestID = requestID;
		this.receiptNote = receiptNote;
	}
	
	// Instance Variables
	
	private int receiptID;
	private File imageFile;
	private int requestID;
	private String receiptNote;
	public int getReceiptID() {
		return receiptID;
	}
	
	// Getters & Setters

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getReceiptNote() {
		return receiptNote;
	}

	public void setReceiptNote(String receiptNote) {
		this.receiptNote = receiptNote;
	}

	
	
	// Methods
	
	@Override
	public String toString() {
		return "Receipt [receiptID=" + receiptID + ", imageFile=" + imageFile + ", requestID=" + requestID
				+ ", receiptNote=" + receiptNote + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + receiptID;
		result = prime * result + ((receiptNote == null) ? 0 : receiptNote.hashCode());
		result = prime * result + requestID;
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
		Receipt other = (Receipt) obj;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		} else if (!imageFile.equals(other.imageFile))
			return false;
		if (receiptID != other.receiptID)
			return false;
		if (receiptNote == null) {
			if (other.receiptNote != null)
				return false;
		} else if (!receiptNote.equals(other.receiptNote))
			return false;
		if (requestID != other.requestID)
			return false;
		return true;
	}
	
	
	
}
