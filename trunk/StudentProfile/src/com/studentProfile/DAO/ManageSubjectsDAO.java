package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import com.studentProfile.model.entity.*;
import com.studentProfile.util.LogMessage;

public class ManageSubjectsDAO extends BaseDAO {
	public ArrayList<SubjectModel> getSubjectsList() {
		ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
		String query = "SELECT * from subject";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				SubjectModel subject = new SubjectModel();
				subject.setFacID(rs.getInt("facId"));
				subject.setSemID(rs.getInt("semId"));
				subject.setSubCode(rs.getString("subCode"));
				subject.setSubID(rs.getInt("subId"));
				subject.setSubName(rs.getString("subName"));
				subject.setSubSyllabus(rs.getString("subSyllabus"));
				subjectList.add(subject);

			}
		} catch (SQLException e) {
			LogMessage
					.log("Exception Caught in ManageSubjectsDAO.getSubjectsList");
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
		}

		return subjectList;
	}

	public int addSubject(SubjectModel subject) {
		String query = "INSERT INTO subject(subCode,subName,subSyllabus,semID,facID) VALUES(";
		query += subject.getSubCode() + "," + subject.getSubName() + ","
				+ subject.getSubSyllabus() + "," + subject.getSemID() + ","
				+ subject.getFacID() + ")";
		update(query);
		return 0;
	}

	public int updateSubject(SubjectModel subject) {
		String query = "UPDATE subject SET ";
		query += "subCode=" + subject.getSubCode() + ", ";
		query += "subName=" + subject.getSubName() + ", ";
		query += "subSyllabus=" + subject.getSubSyllabus() + ", ";
		query += "semID=" + subject.getSemID() + ", ";
		query += "facID=" + subject.getFacID() + " ";
		query += "WHERE subID=" + subject.getSubID();
		update(query);
		return 0;
	}

	public int deleteSubject(int subID) {
		String query = "DELETE FROM subject WHERE subID=" + subID;
		update(query);
		return 0;
	}

	public ArrayList<SemesterModel> getSemesterList() {
		ArrayList<SemesterModel> semList = new ArrayList<SemesterModel>();
		String query = "SELECT * from semester";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				SemesterModel semester = new SemesterModel();
				semester.setSemID(rs.getInt("semID"));
				semester.setSemName(rs.getString("semName"));
				semList.add(semester);

			}
		} catch (SQLException e) {
			LogMessage
					.log("Exception Caught in ManageSubjectsDAO.getSemesterList");
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
		}
		return semList;
	}

	public ArrayList<FacultyModel> getFacultyList() {
		ArrayList<FacultyModel> facList = new ArrayList<FacultyModel>();
		String query = "SELECT * from faculty";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				FacultyModel faculty = new FacultyModel();
				faculty.setFacID(rs.getInt("facID"));
				faculty.setFacName(rs.getString("facName"));
				facList.add(faculty);

			}
		} catch (SQLException e) {
			LogMessage
					.log("Exception Caught in ManageSubjectsDAO.getSemesterList");
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
		}
		return facList;
	}

}
