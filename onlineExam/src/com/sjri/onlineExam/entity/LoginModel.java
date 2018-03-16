package com.sjri.onlineExam.entity;

public class LoginModel {

	private int userID;
	private String username;
	private String email;
	private String psword;
	private String role;
	private int companyOrCollegeId;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCompanyOrCollegeId() {
		return companyOrCollegeId;
	}

	public void setCompanyOrCollegeId(int companyOrCollegeId) {
		this.companyOrCollegeId = companyOrCollegeId;
	}

	@Override
	public String toString() {
		return "LoginModel [userID=" + userID + ", username=" + username + ", email=" + email + ", psword=" + psword
				+ ", role=" + role + ", companyOrCollegeId=" + companyOrCollegeId + ", address=" + address + "]";
	}

}
