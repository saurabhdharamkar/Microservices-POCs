package com.example.demo.entity;

import java.util.Date;


public class User {

	private int userId;
	
	private String userName;
	
	private String age;
	
	private String mobileNo;
	
	private String emailId;
	
//	@Column(name="current_date")
//	private Date currentDate;
	
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
//
//	public Date getCurrentDate() {
//		return currentDate;
//	}
//
//	public void setCurrentDate(Date currentDate) {
//		this.currentDate = currentDate;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
	
	
	

}
