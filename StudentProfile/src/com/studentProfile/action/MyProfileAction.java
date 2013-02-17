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

	public ArrayList<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<InterestModel> interests) {
		this.interests = interests;
	}

	public String myProfile() {
		System.out.println("myprofile ()");
		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			return ERROR;
		}
		LogMessage
				.log("Message From MyProfileAction.profilePic : Arguments :: stuID:"
						+ student.getStuID());
		InterestDAO interestDAO = new InterestDAO();
		ArrayList<InterestModel> ints = interestDAO.getInterests(student
				.getStuID());
		if (ints != null) {
			setInterests(ints);
			LogMessage.log("size of interests list:" + interests.size());
		} else {
			addActionMessage("No interests added for this student yet");
		}
		return Action.SUCCESS;
	}
}
