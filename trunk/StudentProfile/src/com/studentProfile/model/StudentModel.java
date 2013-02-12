package com.studentProfile.model;

import java.io.File;
import java.util.Date;
import java.util.Timer;
/**
 * 
 * @author svkris
 *
 *Model class for student
 */
public class StudentModel {
	private Integer stuID;
	private Integer intID;
	private String stuName;
	private String stuPassword;
	private byte[] stuPhoto;
	private Timer stuLoggedIn;
	private String stuRollNo;
	private Date stuDOB;

	public Integer getStuID() {
		return stuID;
	}

	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}

	public Integer getIntID() {
		return intID;
	}

	public void setIntID(Integer intID) {
		this.intID = intID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
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
