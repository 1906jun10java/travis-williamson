package com.revature.beans;

public class Employee {
	
	// Constructors
	
	public Employee(int employeeID, String firstName, String lastName, int departmentID, double salary,
			String employeeEmail) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentID = departmentID;
		this.salary = salary;
		this.employeeEmail = employeeEmail;
	}
	
	// Instance Variables
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private int departmentID;
	private double salary;
	private String employeeEmail;
	
	// Getters and Setters
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", departmentID=" + departmentID + ", salary=" + salary + ", employeeEmail=" + employeeEmail + "]";
	}
	
}
