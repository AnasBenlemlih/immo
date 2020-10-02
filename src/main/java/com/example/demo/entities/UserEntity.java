package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -9146487759870644513L;
	
	@Id
	@GeneratedValue
	private long id;
	private String userId;

	@Column(nullable = false,length = 50)
	private String firstName;
	
	@Column(nullable = false,length = 50)
	private String lastName;
	
	@Column(nullable = false,length = 100,unique = true)
	private String email;
	
	@Column(nullable = false)
	private String encryptePassword;
	
	@Column(nullable = true)
	private String emailverifToken;
	
	@Column(nullable = false)
	private Boolean emailverifStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Boolean getEmailverifStatus() {
		return emailverifStatus;
	}

	public void setEmailverifStatus(Boolean emailverifStatus) {
		this.emailverifStatus = emailverifStatus;
	}
	
	
	

}
