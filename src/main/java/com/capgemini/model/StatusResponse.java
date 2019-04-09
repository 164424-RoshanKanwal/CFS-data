package com.capgemini.model;

public class StatusResponse {

	private int statusCode;
	private String message;
	public StatusResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatusResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "StatusResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
	
	
}
