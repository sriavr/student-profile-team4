/**
 * EnrollCourseDAO.java
 * Date:	4 Feb 2013
 */
package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.SubjectModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class EnrollCourseDAO {

	// Retrive all the semester to show dropdown list in enrollCourse.jsp
	public static ArrayList<SemesterModel> showSemInfo() {
		ArrayList<SemesterModel> sem = new ArrayList<SemesterModel>();
		ResultSet resultSet;
		String query = "SELECT * FROM semester";
		System.out.println("Query is: " + query);
		resultSet = BaseDAO.readFromDB(query);
		try {
			while (resultSet.next()) {
				sem.add(getSemObject(resultSet));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		BaseDAO.close(resultSet);
		return sem;

	}// End of displaySem()

	// create a semester object
	public static SemesterModel getSemObject(ResultSet rs) {

		SemesterModel semModel = new SemesterModel();
		try {
			semModel.setSemID(rs.getInt("semID"));
			semModel.setSemName(rs.getString("semName"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return semModel;

	}// End of getSemObject().

	// Retrieve the all subject in whose semseter id is semID .
	public static ArrayList<SubjectModel> showSubjectInfo(int semID) {
		ArrayList<SubjectModel> subject = new ArrayList<SubjectModel>();
		// get the student id from session object.
		Map<String, Object> session;
		int studentID;

		// get the user information from session object.
		/*
		session = ActionContext.getContext().getSession();
		UserModel user = (UserModel) session.get("user");
		StudentModel student = (StudentModel) session.get("session");
		if (user.getRole().equalsIgnoreCase("student")) {
			studentID = student.getStuID();
		} else {
			addActionMessage("There is no subject for Admin");
			return "success";
		}
		 */ 
		studentID = 2;
		String query = "SELECT * FROM subject WHERE NOT EXISTS (SELECT enrID FROM enrollment "
				+ "WHERE subject.subID=enrollment.subID and enrollment.stuID="
				+ studentID + ") AND subject.semID=" + semID;
		System.out.println("Method: " + "EnrollCourse.showSubject\n"
				+ "Query String is : " + query);
		ResultSet resultSet;
		resultSet = BaseDAO.readFromDB(query);
		try {
			while (resultSet.next()) {
				subject.add(getSubjectObject(resultSet));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		BaseDAO.close(resultSet);
		return subject;

	}// End of showSubjectInfo.

	// Get the object of SubjectModel from resultset
	public static SubjectModel getSubjectObject(ResultSet rs) {
		SubjectModel subjectModel = new SubjectModel();
		try {
			subjectModel.setFacID(rs.getInt("facID"));
			subjectModel.setSemID(rs.getInt("semID"));
			subjectModel.setSubID(rs.getInt("subID"));
			subjectModel.setSubCode(rs.getString("subCode"));
			subjectModel.setSubName(rs.getString("subName"));
			subjectModel.setSubSyllabus(rs.getString("subSyllabus"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return subjectModel;
	}// End of getSubjectObject.

	// insert the subject id and stdent id in enrollment table for
	// successful enrollment..
	public static int enrollStudent(int subID, int stuID) {
		String Query;
		Query = "INSERT INTO `enrollment` (`subID`, `stuID`, `enrGrade`)  "
				+ " VALUES(" + subID + ", " + stuID + ", " + "'NA')";
		return BaseDAO.update(Query);

	}
}
