package com.studentProfile.action;

//package com.studentProfile.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.MyFriendsDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.StudentModel;

public class MyFriendsAction extends ActionSupport {

	/**
	 * 
	 */
	ArrayList<StudentModel> friendsList = new ArrayList<StudentModel>();
	private int stu_ID;

	public int getStu_ID() {
		return stu_ID;
	}

	public void setStu_ID(int stu_ID) {
		this.stu_ID = stu_ID;
	}

	public ArrayList<StudentModel> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(ArrayList<StudentModel> friendsList) {
		this.friendsList = friendsList;
	}

	String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	// public ArrayList<SubjectModel> getSubjectList() {
	// return subjectList;
	// }
	// public void setSubjectList(ArrayList<SubjectModel> subjectList) {
	// this.subjectList = subjectList;
	// }
	// public ArrayList<GradesModel> getGradesList() {
	// return gradesList;
	// }
	// public void setGradesList(ArrayList<GradesModel> gradesList) {
	// this.gradesList = gradesList;
	// }
	// ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
	// ArrayList<GradesModel> gradesList = new ArrayList<GradesModel>();
	String selectedSemesterId = "";
	String selectedSubjectId = "0";

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

	HttpServletResponse response = ServletActionContext.getResponse();

	public String execute() {
		System.out.println("here.....");
		
		MyFriendsDAO myFriendsDAO = new MyFriendsDAO();

		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		if (student == null || student.getStuID() == 0) {
			return "login";
		}
		friendsList = myFriendsDAO.getFriends(student.getStuID());
		
		System.out.println("size:" + friendsList.size());
		
		return SUCCESS;

	}

	
}

// public class MyFriendsAction {
//
// }
