package com.studentProfile.model;

public class AdminModel {
	private Integer admID;
	private String  admUserName;
	private String  admName;
	private String 	admPassword;
	
	public String getAdmUserName() {
		return admUserName;
	}
	public void setAdmUserName(String admUserName) {
		this.admUserName = admUserName;
	}
	public Integer getAdmID() {
		return admID;
	}
	public void setAdmID(Integer admID) {
		this.admID = admID;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	
}
