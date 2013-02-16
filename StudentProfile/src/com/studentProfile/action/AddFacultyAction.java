package com.studentProfile.action;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.AddFacultyDAO;

public class AddFacultyAction extends ActionSupport {
	private String facName;
	private String msg;

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String execute() throws Exception {
		AddFacultyDAO addFacultyDAO = new AddFacultyDAO();
		if (addFacultyDAO.addFaculty(facName)) {
			msg = "Successfully added faculty";
			facName = "";
		} else {
			msg = "Unable to add faculty";
		}
		return SUCCESS;
	}
}
