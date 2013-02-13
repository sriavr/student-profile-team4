package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageSubjectsDAO;
import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.SubjectModel;

public class ManageSubjectsAction extends ActionSupport{
	private Integer subID;
	private String subCode;
	private String subName;
	private String subSyllabus;
	private Integer semID;
	private Integer facID;
	private ArrayList<FacultyModel> facList;
	private ArrayList<SubjectModel> subjectList;
	private ArrayList<SemesterModel> semList;
	
	
	public Integer getSubID() {
		return subID;
	}

	public void setSubID(Integer subID) {
		this.subID = subID;
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

	public ArrayList<SemesterModel> getSemList() {
		return semList;
	}

	public void setSemList(ArrayList<SemesterModel> semList) {
		this.semList = semList;
	}

	public void setFacList(ArrayList<FacultyModel> facList) {
		this.facList = facList;
	}

	
	public ArrayList<FacultyModel> getFacList() {
		return facList;
	}

	public ArrayList<SubjectModel> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<SubjectModel> subjectList) {
		this.subjectList = subjectList;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
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
		ManageSubjectsDAO manageSubjectsDAO = new ManageSubjectsDAO();
		this.setFacList(manageSubjectsDAO.getFacultyList());
		this.setSemList(manageSubjectsDAO.getSemesterList());
		this.setSubjectList(manageSubjectsDAO.getSubjectsList());
		return Action.SUCCESS;
	}
	
	public String manageSubjectsAddSubjectAction(){
		ManageSubjectsDAO manageSubjectsDAO = new ManageSubjectsDAO();
		SubjectModel subject = new SubjectModel();
		subject.setSubCode(subCode);
		subject.setSubName(subName);
		subject.setSubSyllabus(subSyllabus);
		subject.setSemID(semID);
		subject.setFacID(facID);
		Integer value =manageSubjectsDAO.addSubject(subject);
		if (value == 0)
			return Action.SUCCESS;
		else
			return Action.ERROR;
	}
	public String manageSubjectsEditSubjectAction(){
		ManageSubjectsDAO manageSubjectsDAO = new ManageSubjectsDAO();
		SubjectModel subject = new SubjectModel();
		subject.setSubCode(subCode);
		subject.setSubName(subName);
		subject.setSubSyllabus(subSyllabus);
		subject.setSemID(semID);
		subject.setFacID(facID);
		Integer value =manageSubjectsDAO.updateSubject(subject);
		if (value == 0)
			return Action.SUCCESS;
		else
			return Action.ERROR;
		
	}
	public String manageSubjectsRemoveSubjectAction(){
		ManageSubjectsDAO manageSubjectsDAO = new ManageSubjectsDAO();
		SubjectModel subject = new SubjectModel();
		subject.setSubID(subID);
		subject.setSubName(subName);
		subject.setSubSyllabus(subSyllabus);
		subject.setSemID(semID);
		subject.setFacID(facID);
		Integer value =manageSubjectsDAO.deleteSubject(subject.getSubID());
		if (value == 0)
			return Action.SUCCESS;
		else
			return Action.ERROR;
		
	}
}
