package com.studentProfile.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.studentProfile.DAO.UpdateGradesDAO;
import com.studentProfile.util.DatabaseUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateGradeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	int subjectid;
	String studentroll;
	String studentgrade;
	String studentid;
	String subjectname;
	int enableFlag=0;
	public String getSubjectname() {
		return subjectname;
	}


	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}


	public String getStudentid() {
		return studentid;
	}


	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}


	public int getSubjectid() {
		return subjectid;
	}


	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}


	public String getStudentroll() {
		return studentroll;
	}


	public void setStudentroll(String studentroll) {
		this.studentroll = studentroll;
	}


	public String getStudentgrade() {
		return studentgrade;
	}


	public void setStudentgrade(String studentgrade) {
		this.studentgrade = studentgrade;
	}


	public String execute()  throws ClassNotFoundException{
		
		String query1,query2,query3,query4;
		ResultSet result1,result2,result3;
		Connection con = null;
		
		
		UpdateGradesDAO updateGradesDAO=new UpdateGradesDAO();
		try{
			
			query1="select stuID from student where stuRollNo='"+studentroll+"'";
			//result1=statement.executeQuery(query1);
			result1=updateGradesDAO.getStudentID(query1);
			if(result1.next()){
				studentid=result1.getString(1);
			}
			
			////////////////////////////////////////////////////////////////
			
			
			query2="select subID from subject where subName='"+subjectname+"'";
			//result2=statement.executeQuery(query2);
			result2=updateGradesDAO.getSubjectID(query2);
			if(result2.next()){
				subjectid=result2.getInt(1);
			}
			
			//////////////////////////////////////////////////////////////
			
			
			query3="select subID from enrollment where stuID="+studentid;
			//result3=statement.executeQuery(query3);
			result3=updateGradesDAO.getSubjectIDfromStudentID(query3);
			while(result3.next()){
				if(subjectid==result3.getInt(1))
					enableFlag=1;
			}
			
			if(enableFlag==0)
				return "failure";
			
			
			/////////////////////////////////////////////////////////////
			
			query4=" update enrollment set enrGrade='"+studentgrade+"'";
			query4+=	" where  subID="+subjectid+" and  stuID="+studentid;
			//DatabaseUtil.connect();
			
			//statement.executeUpdate(query4);
			int x=updateGradesDAO.updateGrades(query4);
			
			if(x==1)
			return "success";
			
			else
				return "failure";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "failure";
		
	}
	

}
