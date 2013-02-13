package com.studentProfile.action;


import java.util.*;

import com.studentProfile.DAO.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.model.entity.*;
import com.studentProfile.util.LogMessage;
public class ManageUsersAction extends ActionSupport{
	
	List<StudentModel> students = new ArrayList<StudentModel>();
	List<StudentModel> Selectedstudents = new ArrayList<StudentModel>();
	
	int maxStudentId;

	private Integer stuID;
	private String stuRollNo;
	private String stuName;
	private String stuPassword;
	ArrayList<Integer> studentArray = new ArrayList<Integer>();
	
	
	public String manageUsers() throws ClassNotFoundException{
	
		LogMessage
		.log("Message From ManageUsersAction.manageUsers : Arguments :: no");
		//System.out.println("first tym");
		StudentDAO s = new StudentDAO(); 
		students = s.allStudents();	
		maxStudentId = s.getMaxStudentId();
		return Action.SUCCESS;
	}
	 
	public String manageUsersUpdation() throws ClassNotFoundException{
		
		LogMessage
		.log("Message From ManageUsersAction.manageUsersUpdation : Arguments :: no");
		
		StudentDAO s = new StudentDAO();
		maxStudentId = s.getMaxStudentId();
		System.out.println("size of students  : " + Selectedstudents.size() );
		//System.out.println("stuID="+stuID+"&stuRollNo="+stuRollNo+"&stuName="+stuName+"&stuPassword="+stuPassword);
		
		for(int i = 0;i<Selectedstudents.size();i++){
			
			StudentModel stuObject = Selectedstudents.get(i);
			System.out.println("stu NO : " + stuObject.getStuID());

			System.out.println("stu NO : " + stuObject.getStuName());
			System.out.println("stu NO : " + stuObject.getStuPassword());
			System.out.println("stu NO : " + stuObject.getStuRollNo());
			
			if(stuObject.getStuID() <= maxStudentId){
				//UPDATE QUERY
				if(s.updateStudentDetails(stuObject.getStuID(), stuObject.getStuName(), stuObject.getStuPassword())){
					manageUsers();
					System.out.println("updated stu INfo");
				}
				else{
					//return Action.ERROR;
				}
			}
			else{
				//insert query
				if(s.insertNewStudent(stuObject.getStuID(), stuObject.getStuName(), 
						stuObject.getStuPassword(),stuObject.getStuRollNo())){
					manageUsers();
					System.out.println("inserted new student");
				}
				else{
					//return Action.ERROR;
				}
				
			}
		}
		return Action.SUCCESS;
	}
	
	public String manageUsersRemove() throws ClassNotFoundException{
		
		LogMessage
		.log("Message From ManageUsersAction.manageUsersRemove : Arguments :: no");
		
		StudentDAO s = new StudentDAO();
		for(int i=0;i<studentArray.size();i++){
			System.out.println("remove id stuID="+studentArray.get(i));
			if(s.removeStudent(studentArray.get(i))){
				System.out.println("removed stuID="+studentArray.get(i));
			}
			else{
				return Action.ERROR;
			}
				
		}
		manageUsers();
		return Action.SUCCESS;
	}
	
	

	public List<StudentModel> getStudents() {
		return students;
	}

	public void setStudents(List<StudentModel> students) {
		this.students = students;
	}

	public List<StudentModel> getSelectedstudents() {
		return Selectedstudents;
	}

	public void setSelectedstudents(List<StudentModel> selectedstudents) {
		Selectedstudents = selectedstudents;
	}

	public int getMaxStudentId() {
		return maxStudentId;
	}

	public void setMaxStudentId(int maxStudentId) {
		this.maxStudentId = maxStudentId;
	}

	public Integer getStuID() {
		return stuID;
	}

	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}

	public String getStuRollNo() {
		return stuRollNo;
	}

	public void setStuRollNo(String stuRollNo) {
		this.stuRollNo = stuRollNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public ArrayList<Integer> getStudentArray() {
		return studentArray;
	}

	public void setStudentArray(ArrayList<Integer> studentArray) {
		this.studentArray = studentArray;
	}
	
	
}
