package com.cognizant.myProject.dto;



import java.util.Optional;

import com.cognizant.myProject.model.Address;

public class UserAddress {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String email;
	private Optional<Address> address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Optional<Address> getAddress() {
		return address;
	}
	public void setAddress(Optional<Address> address) {
		this.address = address;
	}

	public UserAddress(int id, String firstName, String lastName, int age, String gender, String email,
			Optional<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}
	public UserAddress() {
		super();
	}
	
	
}
