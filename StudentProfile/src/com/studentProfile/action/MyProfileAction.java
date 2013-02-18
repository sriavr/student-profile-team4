package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.InterestDAO;
import com.studentProfile.model.entity.InterestModel;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.LogMessage;

public class MyProfileAction extends ActionSupport {
	private ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
	private String stuID="";
	StudentModel student;

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public ArrayList<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<InterestModel> interests) {
		this.interests = interests;
	}

	public String myProfile() {
		System.out.println("myprofile ()");
		student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			return ERROR;
		}
		LogMessage
				.log("Message From MyProfileAction.profilePic : Arguments :: stuID:"
						+ student.getStuID());
		InterestDAO interestDAO = new InterestDAO();
		ArrayList<InterestModel> ints;
		System.out.println("student ID:"+stuID);
		if(stuID.equals(""))
		{	
			 ints = interestDAO.getInterests(student
				.getStuID());
		}
		else
		{
			ints = interestDAO.getInterests(Integer.parseInt(stuID));
			
		}
		if (ints != null) {
			setInterests(ints);
			LogMessage.log("size of interests list:" + interests.size());
		} else {
			addActionMessage("No interests added for this student yet");
		}
		return Action.SUCCESS;
	}
}
