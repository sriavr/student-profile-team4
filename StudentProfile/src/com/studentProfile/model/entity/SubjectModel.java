package com.studentProfile.model.entity;

public class SubjectModel {
	
	private int subID;
	private boolean selected;
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
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
	
	private String subCode;
	private String subName;
	private String subSyllabus;
	private int semID;
	private int facID;
	public int getSemID() {
		return semID;
	}
	public void setSemID(int semID) {
		this.semID = semID;
	}
	public int getFacID() {
		return facID;
	}
	public void setFacID(int facID) {
		this.facID = facID;
	}
	
	

}