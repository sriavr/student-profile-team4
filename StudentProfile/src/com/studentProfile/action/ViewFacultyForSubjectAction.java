package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.SubjectsDAO;
import com.studentProfile.DAO.ViewFacultyForSubjectDAO;
import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.util.LogMessage;

public class ViewFacultyForSubjectAction extends ActionSupport {
	private String subID;
	private SubjectModel subject = new SubjectModel();
	private ArrayList<FacultyModel> facultyList = new ArrayList<FacultyModel>();

	public SubjectModel getSubject() {
		return subject;
	}

	public String getSubID() {
		return subID;
	}

	public void setSubID(String subID) {
		this.subID = subID;
	}

	public void setSubject(SubjectModel subject) {
		this.subject = subject;
	}

	public ArrayList<FacultyModel> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(ArrayList<FacultyModel> facultyList) {
		this.facultyList = facultyList;
	}

	@Override
	public String execute() throws Exception {
		ViewFacultyForSubjectDAO dao = new ViewFacultyForSubjectDAO();
		ArrayList<FacultyModel> facultyList = new ArrayList<FacultyModel>();
		SubjectsDAO subDao = new SubjectsDAO();
		LogMessage.log("Inside ViewFaculyForSubjectAction. subID=" + subID);
		facultyList = dao.getFacultyList(Integer.parseInt(subID));
		if (facultyList != null) {
			this.setFacultyList(facultyList);
			subject = SubjectsDAO.getSubjectDetails(Integer.parseInt(subID));
		} else {
			LogMessage.log("Error occurred");
			return ERROR;
		}
		return SUCCESS;
	}
}
