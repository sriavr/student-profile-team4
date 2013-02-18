package com.studentProfile.model.page;
import java.util.ArrayList;

import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.SemesterModel;
public class ManageSubjectsModel {
	
	private int subID;
	private String subCode;
	private String subName;
	private String subSyllabus;
	private int selectedsemID;
	private int selectedfacID;
	
	private ArrayList<FacultyModel> facultyList;
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
	public int getSelectedsemID() {
		return selectedsemID;
	}
	public void setSelectedsemID(int selectedsemID) {
		this.selectedsemID = selectedsemID;
	}
	public int getSelectedfacID() {
		return selectedfacID;
	}
	public void setSelectedfacID(int selectedfacID) {
		this.selectedfacID = selectedfacID;
	}
	public ArrayList<FacultyModel> getFacultyList() {
		return facultyList;
	}
	public void setFacultyList(ArrayList<FacultyModel> facultyList) {
		this.facultyList = facultyList;
	}
	public ArrayList<SemesterModel> getSemesterList() {
		return semesterList;
	}
	public void setSemesterList(ArrayList<SemesterModel> semesterList) {
		this.semesterList = semesterList;
	}
	private ArrayList<SemesterModel> semesterList;
	

}
