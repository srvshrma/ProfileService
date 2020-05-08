package com.cognizant.myProject.model;




public class Address {
	
	private int user_id;
	
	private String permanentAddress;
	
	private String currentAddress;
	public Address(String permanentAddress, String currentAddress) {
		super();
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
	}
	public Address() {
		super();
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPresentAddress() {
		return currentAddress;
	}
	public void setPresentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
