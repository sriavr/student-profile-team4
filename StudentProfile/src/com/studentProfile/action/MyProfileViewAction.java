package com.studentProfile.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.model.entity.StudentModel;


public class MyProfileViewAction extends ActionSupport {
	
	StudentModel student = new StudentModel();
	public StudentModel getStudent() {
		return student;
	}
	public void setStudent(StudentModel student) {
		this.student = student;
	}
	public String execute()
	{
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		//UserModel u =  (UserModel) sessionMap.get("user");
		StudentModel student = (StudentModel) sessionMap.get("student");
		
		if(student==null)
			return ERROR;
		
		this.student=student;
	   	
		return SUCCESS;
	}

}
