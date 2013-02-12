package com.studentProfile.model;

public class UserModel {
	private int usrID;
	private String usrName;
	private String password;
	private String role;

	public int getUsrID() {
		return usrID;
	}

	public void setUsrID(int usrID) {
		this.usrID = usrID;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
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

}
