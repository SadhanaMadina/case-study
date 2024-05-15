package com.java.ecommerce.model;

public class Customers {
	private int customer_id ;
	private String first_name;
	private String last_name; 
	private String email ;
	private String password;
	private String address;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", password=" + password + ", address=" + address + "]";
	}
	public Customers(int customer_id, String first_name, String last_name, String email, String password,
			String address) {
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public Customers() {
		
	}
	

}