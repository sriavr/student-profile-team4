package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.model.page.GradesModel;

public class GradesDAO extends BaseDAO {
	
	
	public ArrayList<SemesterModel> getSemesters()
	{
		 String query = "select semID,semName from semester";
		 ArrayList<SemesterModel> semesters = new ArrayList<SemesterModel>();
		 ResultSet rs=readFromDB(query);
		 try
		 {
		 while(rs.next())
		 {
			 SemesterModel semesterModel =  new SemesterModel();
			 semesterModel.setSemID(rs.getInt(1));
			 semesterModel.setSemName(rs.getString(2));
			 semesters.add(semesterModel);
			 
		 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 
		 }
		 finally
		 {
			 close(rs);
		 }
		 
		return semesters;
		
	}
	
	public ArrayList<SubjectModel> getSubjects(int semId)
	{
		 String query = "select * from subject where semID="+semId;
		 ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();
		 
		 ResultSet rs=readFromDB(query);
		 try
		 {
		 while(rs.next())
		 {
			 SubjectModel subjectModel =  new SubjectModel();
			 subjectModel.setSubID(rs.getInt(1));
			 subjectModel.setSubName(rs.getString(3));
			 subjectModel.setSubCode(rs.getString(2));
			 subjectModel.setSubSyllabus(rs.getString(4));
			 subjects.add(subjectModel);
		 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 
		 }
		 finally
		 {
			 close(rs);
		 }
		 
		return subjects;
		
	}
	
	public ArrayList<GradesModel> getGrades(int semId,int subId,int stuId)
	{
		 String query = "select subName,subCode,e.enrGrade from enrollment e,subject s where s.semId="+semId;
		 query+= " and s.subId=e.subId";
		 query+= " and e.stuID="+stuId;
		 if(subId!=0)
		 {
			 query+=" and s.subId="+subId;
			 
		 }
		 System.out.println("grades query:"+query);
		 ArrayList<GradesModel> grades = new ArrayList<GradesModel>();
		 
		 ResultSet rs=readFromDB(query);
		 try
		 {
		 while(rs.next())
		 {
			
			 GradesModel gradesModel =  new GradesModel();
			 gradesModel.setSubject(rs.getString(1));
			 gradesModel.setSubject_code(rs.getString(2));
			 gradesModel.setGrade(rs.getString(3));
			 if(gradesModel.getGrade().contains("F"))
				 gradesModel.setResult("FAIL");
			 else if(gradesModel.getGrade().contains("NA"))
				 gradesModel.setResult("");
			 else
				 gradesModel.setResult("PASS");
			 grades.add(gradesModel);
		 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 
		 }
		 finally
		 {
			 close(rs);
		 }
		 
		return grades;
		
	}
	
	

}
