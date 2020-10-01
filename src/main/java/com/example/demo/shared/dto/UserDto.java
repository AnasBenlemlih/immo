package com.example.demo.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6407688734661559517L;
	
	
	private long id;
	private String userId;


	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptePassword;
	private String emailverifToken;
	private Boolean emailverifStatus = false;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getEncryptePassword() {
		return encryptePassword;
	}
	public void setEncryptePassword(String encryptePassword) {
		this.encryptePassword = encryptePassword;
	}
	public String getEmailverifToken() {
		return emailverifToken;
	}
	public void setEmailverifToken(String emailverifToken) {
		this.emailverifToken = emailverifToken;
	}
	public Boolean isEmailverifStatus() {
		return emailverifStatus;
	}
	public void setEmailverifStatus(Boolean emailverifStatus) {
		this.emailverifStatus = emailverifStatus;
	}
	
	
}
