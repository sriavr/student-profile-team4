package com.studentProfile.action;

//package com.studentProfile.action;

import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
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
	

//	public ArrayList<SubjectModel> getSubjectList() {
//		return subjectList;
//	}
//	public void setSubjectList(ArrayList<SubjectModel> subjectList) {
//		this.subjectList = subjectList;
//	}
//	public ArrayList<GradesModel> getGradesList() {
//		return gradesList;
//	}
//	public void setGradesList(ArrayList<GradesModel> gradesList) {
//		this.gradesList = gradesList;
//	}
//	ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
//	ArrayList<GradesModel> gradesList = new ArrayList<GradesModel>();
	String selectedSemesterId="";
	String selectedSubjectId="0";
	
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
	
	public String execute()
	{
		System.out.println("here.....");
		MyFriendsDAO myFriendsDAO = new MyFriendsDAO();
//		if(selectedSemesterId.equals(""))
//		{
//			semesterList=gradesDAO.getSemesters();
//			
//		}
//		else
//		{
			friendsList=myFriendsDAO.getFriends("2");
//			subjectList = gradesDAO.getSubjects(Integer.parseInt(selectedSemesterId));
//			gradesList = gradesDAO.getGrades(Integer.parseInt(selectedSemesterId), Integer.parseInt(selectedSubjectId), 2);
//			System.out.println("grade list size:"+gradesList.size());
			System.out.println("size:"+friendsList.size());
//		}
		return SUCCESS;
		
	}
	
	
public String retPicture(){
		
	StudentDAO studentDAO = new StudentDAO();
	StudentModel curUser = new StudentModel();
			
	System.out.println("the picture other profile of user_id"+getStu_ID());
		
			curUser = studentDAO.getStudent(getStu_ID());
		
		response.setContentType("image/jpeg");
		try{
		OutputStream out = response.getOutputStream();
		//System.out.println("here in userprofile retPicture()"+curUser.getPicData());
		//System.out.println("here i am userprofile retPicture()"+curUser.getUser_id());
        out.write(curUser.getStuPhoto());
        out.close();
		}
		catch(Exception e){
			System.out.println("Exception Caught in UserProfile.retPicture");
			e.printStackTrace();
		}
		
		return "success";
	}
}

//public class MyFriendsAction {
//
//}
