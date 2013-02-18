package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.util.LogMessage;
import com.studentProfile.DAO.InterestDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.*;


public class ProfilePicAction extends ActionSupport {

	public StudentModel student = new StudentModel();
	public String stuID="";
	private ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
    private boolean disabled;
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public ArrayList<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<InterestModel> interests) {
		this.interests = interests;
	}

	public String profilePic() {
		student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		
		System.out.println("Student ID"+stuID);
		if(stuID.equals(""))
		{	
			setStuID(student.getStuID()+"");
			disabled = false;
		}
		else
		{
			disabled = true;
		}
		LogMessage
				.log("Message From ProfilePicAction.profilePic : Arguments :: stuID:"
						+ getStuID());
		
		StudentDAO studentDAO = new StudentDAO();
		student=studentDAO.getStudent(Integer.parseInt(stuID));
		System.out.println(student.getStuRollNo());
		InterestDAO interestDAO = new InterestDAO();
		ArrayList<InterestModel> ints = interestDAO.getInterests(Integer.parseInt(stuID));
		if (ints != null) {
			setInterests(ints);
			LogMessage.log("size of interests list:" + interests.size());
		} else {
			addActionMessage("No interests added for this student yet");
		}
		return Action.SUCCESS;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}
}
