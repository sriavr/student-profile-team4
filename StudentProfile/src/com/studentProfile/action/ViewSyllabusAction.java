package com.studentProfile.action;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.SubjectsDAO;
import com.studentProfile.model.entity.SubjectModel;

public class ViewSyllabusAction extends ActionSupport {
	private SubjectModel subject = new SubjectModel();
	private int subID;

	public SubjectModel getSubject() {
		return subject;
	}

	public void setSubject(SubjectModel subject) {
		this.subject = subject;
	}

	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	@Override
	public String execute() throws Exception {
		SubjectsDAO subjectsDAO = new SubjectsDAO();
		SubjectModel subject = subjectsDAO.getSubjectDetails(subID);
		if(subject == null)
		{
			return ERROR;
		}
		setSubject(subject);
		return SUCCESS;
	}

}
