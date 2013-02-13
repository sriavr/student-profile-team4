package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageSubjectsDAO;
import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.model.page.SubjectsModel;

public class ManageSubjectsAction extends ActionSupport{
	
	private ArrayList<SubjectModel> subjectList;
	private ArrayList<SemesterModel> semesterLst;
	public ArrayList<SemesterModel> getSemesterLst() {
		return semesterLst;
	}


	public void setSemesterLst(ArrayList<SemesterModel> semesterLst) {
		this.semesterLst = semesterLst;
	}


	public ArrayList<FacultyModel> getFacultylist() {
		return facultylist;
	}


	public void setFacultylist(ArrayList<FacultyModel> facultylist) {
		this.facultylist = facultylist;
	}


	private ArrayList<FacultyModel> facultylist;
	
	
	public ArrayList<SubjectModel> getSubjectList() {
		return subjectList;
	}


	public void setSubjectList(ArrayList<SubjectModel> subjectList) {
		this.subjectList = subjectList;
	}


	public String execute(){
	  
		ManageSubjectsDAO manageSubjectsDAO = new ManageSubjectsDAO();
 		setSubjectList(manageSubjectsDAO.getSubjectsList());
        setSemesterLst(manageSubjectsDAO.getSemesterList());
        setFacultylist(manageSubjectsDAO.getFacultyList());
     		
		
		
		 
		return Action.SUCCESS;
	}
}