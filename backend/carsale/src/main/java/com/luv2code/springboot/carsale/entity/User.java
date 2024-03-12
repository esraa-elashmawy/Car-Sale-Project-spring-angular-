package com.luv2code.springboot.carsale.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private int userId;
	
	@Column(name="full_name",nullable = false)
	private String fullName;
	
	@Column(name="mobile_number",nullable = false)
	private int mobileNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password",nullable = false)
	private String password; 
	
	@Column(name="role",nullable = false)
	private String role;
	

	@OneToMany(mappedBy="buyer")
	private Collection<Visit> visits = new ArrayList<Visit>();

	
	public User() {
		
	}


	public User(int user_id, String fullName, int mobileNumber, String email, String password, String role,
			Collection<Visit> visits) {
		this.userId = user_id;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.visits = visits;
	}





	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}





//	public Visits getVisit() {
//		return visit;
//	}
//
//	public void setVisit(Visits visit) {
//		this.visit = visit;
//	}



}

