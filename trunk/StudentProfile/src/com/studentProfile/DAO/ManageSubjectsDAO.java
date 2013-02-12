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
		}finally{
			close(rs);
		}

		return subjectList;
	}

	public int addSubject(SubjectModel subject) {
		String query = "INSERT INTO subject(subID,subCode,subName,subSyllabus,semID,facID) VALUES(";
		query += subject.getSubID() + "," + subject.getSubCode() + ","
				+ subject.getSubName() + "," + subject.getSubSyllabus() + ","
				+ subject.getSemID() + "," + subject.getFacID() + ")";
		update(query);
		return 0;
	}
	public int updateSubject(SubjectModel subject){
			String query="UPDATE subject SET ";
			query += "subCode="+subject.getSubCode()+", ";
			query += "subName="+subject.getSubName()+", ";
			query += "subSyllabus="+subject.getSubSyllabus()+", ";
			query += "semID="+subject.getSemID()+", ";
			query += "facID="+subject.getFacID()+" ";
			query += "WHERE subID="+subject.getSubID();
			update(query);
		return 0;
	}
	public int deleteSubject(int subID){
		String query="DELETE FROM subject WHERE subID="+subID;
		update(query);
		return 0;
	}
}
