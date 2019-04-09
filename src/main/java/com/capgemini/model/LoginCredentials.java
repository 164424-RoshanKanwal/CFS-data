package com.capgemini.model;

public class LoginCredentials {

	private long empId;
	private String password;
	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginCredentials(long empId, String password) {
		super();
		this.empId = empId;
		this.password = password;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCredentials [empId=" + empId + ", password=" + password + "]";
	}
	
	
	
}
