package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ManageSubjectsAction extends ActionSupport{
	private String subCode;
	private String subjectName;
	private String Syllabus;
	private Integer semID;
	private Integer facID;
	private ArrayList<Integer> semIDList;
	private ArrayList<String> facList;
	private ArrayList<String> subjectNameList;
	private ArrayList<String> subjectCodeList;
	
	public ArrayList<Integer> getSemIDList() {
		return semIDList;
	}

	public void setSemIDList(ArrayList<Integer> semIDList) {
		this.semIDList = semIDList;
	}

	public ArrayList<String> getFacList() {
		return facList;
	}

	public void setFacList(ArrayList<String> facList) {
		this.facList = facList;
	}

	public ArrayList<String> getSubjectNameList() {
		return subjectNameList;
	}

	public void setSubjectNameList(ArrayList<String> subjectNameList) {
		this.subjectNameList = subjectNameList;
	}

	public ArrayList<String> getSubjectCodeList() {
		return subjectCodeList;
	}

	public void setSubjectCodeList(ArrayList<String> subjectCodeList) {
		this.subjectCodeList = subjectCodeList;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSyllabus() {
		return Syllabus;
	}

	public void setSyllabus(String syllabus) {
		Syllabus = syllabus;
	}

	public Integer getSemID() {
		return semID;
	}

	public void setSemID(Integer semID) {
		this.semID = semID;
	}

	public Integer getFacID() {
		return facID;
	}

	public void setFacID(Integer facID) {
		this.facID = facID;
	}

	public String execute(){
		
		return Action.SUCCESS;
	}
}
