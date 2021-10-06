package com.bits.spring.model;

import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User implements Serializable {
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String password;
	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean isPasswordValid(String password) {
		return this.password.equalsIgnoreCase(password);
	}
	
	@Override
	public String toString() {
		return "Name:" + userName + " DOB: " + dob + " Password: " + password;
	}
}
