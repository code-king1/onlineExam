package com.sjri.onlineExam.util;

import java.util.Date;

public class LoginModel {

	private int userID;
	private String username;
	private String email;
	private String psword;
	private String role;
	private Date createdDate;
	private String createdBy;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsword() {
		return psword;
	}

	public void setPsword(String psword) {
		this.psword = psword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "LoginModel [userID=" + userID + ", username=" + username
				+ ", email=" + email + ", psword=" + psword + ", role=" + role
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}

}
