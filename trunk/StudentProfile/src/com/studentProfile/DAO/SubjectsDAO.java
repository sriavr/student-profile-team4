/**
 * SubjectsDAO.java
	Date: feb 7 , 2013
	Description: DAO for show the subject information subject name, faculty,
					grade,enroll and so on subjects.jsp page. 

 */
package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.model.page.SubjectsModel;
import com.studentProfile.util.LogMessage;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class SubjectsDAO {

	// retrive subject Model object from Database.
	public static ArrayList<SubjectsModel> getSubjectInfo(int state, int stuID) {
		ArrayList<SubjectsModel> subject = new ArrayList<SubjectsModel>();
		String Query = "";
		ResultSet resultSet;
		if (state == 1) { // showing own enrolled subject.
			Query = "SELECT s.subID,s.subCode,s.subName,s.subSyllabus,f.facName,sm.semName,enr.enrGrade,enr.stuID "
					+ " FROM subject s JOIN faculty f ON s.facID=f.facID JOIN semester sm "
					+ " ON s.semID=sm.semID LEFT JOIN enrollment enr ON enr.subID=s.subID "
					+ " WHERE enr.stuID=" + stuID;
		} else { // state 2 for showing all.

			Query = "SELECT s.subID,s.subCode,s.subName,s.subSyllabus,f.facName,sm.semName,enr.enrGrade,enr.stuID "
					+ " FROM subject s JOIN faculty f ON s.facID=f.facID JOIN semester sm "
					+ " ON s.semID=sm.semID LEFT JOIN enrollment enr ON enr.subID=s.subID ";
		}
		System.out.println("SubjectDAO: getSubjectInfo: Query: \n" + Query);
		resultSet = BaseDAO.readFromDB(Query);
		try {
			while (resultSet.next()) {
				subject.add(getSubjectObject(resultSet));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return subject;

	}// End of Get

	// create a subjectsModel object from resultSet.
	public static SubjectsModel getSubjectObject(ResultSet rs) {
		SubjectsModel subjectModel = new SubjectsModel();
		try {
			subjectModel.setSubID(rs.getInt("s.subID"));
			subjectModel.setSubCode(rs.getString("s.subCode"));
			subjectModel.setSubName(rs.getString("s.subName"));
			subjectModel.setFacName(rs.getString("f.facName"));
			subjectModel.setSemName(rs.getString("sm.semName"));
			System.out.println("Grade is: " + rs.getString("enr.enrGrade"));
			System.out.println("stuID is: " + rs.getInt("enr.stuID"));

			// check for whether grade is available or not. if
			if (rs.getString("enr.enrGrade") == null) {
				subjectModel.setEnrGrade("NA");
			} else {
				subjectModel.setEnrGrade(rs.getString("enr.enrGrade"));
			}

			// check student has enroll or not.
			if (rs.getInt("enr.stuID") == 0) {
				subjectModel.setIsEnroll("N");
			} else {
				subjectModel.setIsEnroll("Y");
			}
			subjectModel.setStuID(rs.getInt("enr.stuID"));
			System.out.println("Sllanus is: " + rs.getString("s.subSyllabus"));
			subjectModel.setSubSyllabus(rs.getString("s.subSyllabus"));

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return subjectModel;
	}// end of getSubjectObject().

	/**
	 * @author Sridhar Purpose of this method is to use the SubjectModel
	 */

	public static SubjectModel getSubjectDetails(int subID) {
		SubjectModel subject = new SubjectModel();

		String query = "SELECT distinct * FROM subject where subID = " + subID;
		ResultSet rs = BaseDAO.readFromDB(query);
		try {
			while (rs.next()) {
				subject.setSubID(rs.getInt("subID"));
				subject.setFacID(rs.getInt("facID"));
				subject.setSemID(rs.getInt("semID"));
				subject.setSubCode(rs.getString("subCode"));
				subject.setSubName(rs.getString("subName"));
				subject.setSubSyllabus(rs.getString("subSyllabus"));
			}
		} catch (SQLException e) {
			LogMessage.log("Exception caught in newsDAO.getNews");
			e.printStackTrace();
		} finally {
			BaseDAO.close(rs);
		}

		return subject;
	}// end of getSubjectObject().

}// end of subjectDAO class.
