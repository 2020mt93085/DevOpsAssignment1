package com.bits.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
	private String userName;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
