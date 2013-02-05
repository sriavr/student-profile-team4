package com.studentProfile.model.entity;

public class SubjectModel {
	
	private int subId;
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubSyllabus() {
		return subSyllabus;
	}
	public void setSubSyllabus(String subSyllabus) {
		this.subSyllabus = subSyllabus;
	}
	public int getSemId() {
		return semId;
	}
	public void setSemId(int semId) {
		this.semId = semId;
	}
	public int getFacId() {
		return facId;
	}
	public void setFacId(int facId) {
		this.facId = facId;
	}
	private String subCode;
	private String subName;
	private String subSyllabus;
	private int semId;
	private int facId;
	
	

}
