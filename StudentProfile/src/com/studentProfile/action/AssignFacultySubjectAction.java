package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.AssignFacultySubjectDAO;
import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.model.entity.SubjectModel;

/**
 * Purpose is to let the user assign mapping between Faculty and Subjects. As
 * decided, Faculty and Subjects are going to have many to many mappping.
 * 
 * @author sridhar
 * 
 */
public class AssignFacultySubjectAction extends ActionSupport {
	private int selectedFacID;
	private int selectedSubID;
	private ArrayList<FacultyModel> faculties = new ArrayList<FacultyModel>();
	private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ArrayList<SubjectModel> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<SubjectModel> subjects) {
		this.subjects = subjects;
	}

	public int getSelectedFacID() {
		return selectedFacID;
	}

	public ArrayList<FacultyModel> getFaculties() {
		return faculties;
	}

	public void setFaculties(ArrayList<FacultyModel> faculties) {
		this.faculties = faculties;
	}

	public void setSelectedFacID(int selectedFacID) {
		this.selectedFacID = selectedFacID;
	}

	public int getSelectedSubID() {
		return selectedSubID;
	}

	public void setSelectedSubID(int selectedSubID) {
		this.selectedSubID = selectedSubID;
	}

	@Override
	public String execute() throws Exception {
		AssignFacultySubjectDAO facSubDAO = new AssignFacultySubjectDAO();

		if (facSubDAO.getFaculties() != null)
			this.setFaculties(facSubDAO.getFaculties());

		if (facSubDAO.getSubjects() != null)
			this.setSubjects(facSubDAO.getSubjects());

		if ((selectedFacID > 0) && (selectedSubID > 0)) {
			if(facSubDAO.assignFacSub(selectedFacID, selectedSubID))
			{
				setMsg("Successfully assigned faculty to subject");
			}
			else{
				setMsg("Assignment of faculty to subject failed");
			}
		}

		return "assign";
	}
}
