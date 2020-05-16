package com.cognizant.myProject.model;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class Address {
	
	private int user_id;
	
	private String houseNo;
	
	private String streetName;
	private String city;
	
	private long pinCode;
	private String country;
	
	public Address(int user_id, String houseNo, String streetName, String city, long pinCode, String country) {
		super();
		this.user_id = user_id;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.pinCode = pinCode;
		this.country = country;
	}
	

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
