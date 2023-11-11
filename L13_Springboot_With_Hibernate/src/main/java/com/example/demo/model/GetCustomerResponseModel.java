package com.example.demo.model;

public class GetCustomerResponseModel {
	
	private int id;
	private String name;
	private String email;
	private int status;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GetCustomerResponseModel(int id, String name, String email, int status, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
		this.message = message;
	}
	public GetCustomerResponseModel(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public GetCustomerResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
