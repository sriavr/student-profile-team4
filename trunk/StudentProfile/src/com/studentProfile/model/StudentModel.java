package com.studentProfile.model;

import java.io.File;
import java.util.Date;
import java.util.Timer;

import org.apache.catalina.User;

/**
 * 
 * @author svkris, modified by Sridhar
 * 
 *         Model class for student
 */
public class StudentModel {
	private Integer stuID;
	private String stuName;
	private byte[] stuPhoto;
	private Timer stuLoggedIn;
	private String stuRollNo;
	private Date stuDOB;

	private UserModel user = new UserModel();

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Integer getStuID() {
		return stuID;
	}

	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}



	public byte[] getStuPhoto() {
		return stuPhoto;
	}

	public Timer getStuLoggedIn() {
		return stuLoggedIn;
	}

	public void setStuLoggedIn(Timer stuLoggedIn) {
		this.stuLoggedIn = stuLoggedIn;
	}

	public String getStuRollNo() {
		return stuRollNo;
	}

	public void setStuRollNo(String stuRollNo) {
		this.stuRollNo = stuRollNo;
	}

	public Date getStuDOB() {
		return stuDOB;
	}

	public void setStuDOB(Date stuDOB) {
		this.stuDOB = stuDOB;
	}

	public void setStuPhoto(byte[] stuPhoto) {
		this.stuPhoto = stuPhoto;
	}

}
