package com.example.demo.model;

public class CreateEmployeeRequestModel {

	private int id;
	private String name;
	private int sal;
	private String email;
	
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CreateEmployeeModel [id=" + id + ", name=" + name + ", sal=" + sal + ", email=" + email + "]";
	}
	public CreateEmployeeRequestModel(int id, String name, int sal, String email) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.email = email;
	}
	public CreateEmployeeRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
