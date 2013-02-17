package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.util.LogMessage;
import com.studentProfile.DAO.InterestDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.*;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ProfilePicAction extends ActionSupport {

	public StudentModel student = new StudentModel();
	public Integer stuID;
	private ArrayList<InterestModel> interests = new ArrayList<InterestModel>();

	public ArrayList<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<InterestModel> interests) {
		this.interests = interests;
	}

	public String profilePic() {
		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		setStuID(student.getStuID());
		LogMessage
				.log("Message From ProfilePicAction.profilePic : Arguments :: stuID:"
						+ getStuID());
		InterestDAO interestDAO = new InterestDAO();
		ArrayList<InterestModel> ints = interestDAO.getInterests(stuID);
		if (ints != null) {
			setInterests(ints);
			LogMessage.log("size of interests list:" + interests.size());
		} else {
			addActionMessage("No interests added for this student yet");
		}
		return Action.SUCCESS;
	}

	public Integer getStuID() {
		return stuID;
	}

	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}
}
