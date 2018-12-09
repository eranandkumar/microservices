package com.springboot.jpa.springbootjpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "user_role")
	private String role;
	@Column(name = "date_of_birth")
	private Date dob;
	
	
	protected User() {
		
	}
	
	public User(String firstName, String lastName, String role, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.dob = dob;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", dob="
				+ dob + "]";
	}
	
	
	
}
