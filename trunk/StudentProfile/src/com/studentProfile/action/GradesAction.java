package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.GradesDAO;
import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.model.page.GradesModel;

public class GradesAction extends ActionSupport {
   
	ArrayList<SemesterModel> semesterList = new ArrayList<SemesterModel>();
	String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<SemesterModel> getSemesterList() {
		return semesterList;
	}
	public void setSemesterList(ArrayList<SemesterModel> semesterList) {
		this.semesterList = semesterList;
	}
	public ArrayList<SubjectModel> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<SubjectModel> subjectList) {
		this.subjectList = subjectList;
	}
	public ArrayList<GradesModel> getGradesList() {
		return gradesList;
	}
	public void setGradesList(ArrayList<GradesModel> gradesList) {
		this.gradesList = gradesList;
	}
	ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
	ArrayList<GradesModel> gradesList = new ArrayList<GradesModel>();
	String selectedSemesterId="";
	String selectedSubjectId="0";
	
	public String getSelectedSubjectId() {
		return selectedSubjectId;
	}
	public void setSelectedSubjectId(String selectedSubjectId) {
		this.selectedSubjectId = selectedSubjectId;
	}
	public String getSelectedSemesterId() {
		return selectedSemesterId;
	}
	public void setSelectedSemesterId(String selectedSemesterId) {
		this.selectedSemesterId = selectedSemesterId;
	}
	public String execute()
	{
		GradesDAO gradesDAO = new GradesDAO();
		if(selectedSemesterId.equals(""))
		{
			semesterList=gradesDAO.getSemesters();
			
		}
		else
		{
			semesterList=gradesDAO.getSemesters();
			subjectList = gradesDAO.getSubjects(Integer.parseInt(selectedSemesterId));
			gradesList = gradesDAO.getGrades(Integer.parseInt(selectedSemesterId), Integer.parseInt(selectedSubjectId), 2);
			System.out.println("grade list size:"+gradesList.size());
		}
		return SUCCESS;
		
	}
	
	
}
