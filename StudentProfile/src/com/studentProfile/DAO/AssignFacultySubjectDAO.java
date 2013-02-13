package com.studentProfile.DAO;

import java.util.ArrayList;

import com.studentProfile.model.UserModel;
import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.model.entity.SubjectModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class AssignFacultySubjectDAO {

	public ArrayList<SubjectModel> getSubjects() {
		ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();
		DatabaseUtil.connect();
		int flag = 0;
		try {
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from subject");
			LogMessage
					.log("Message From AssignFacultySubjectDAO.login getSubjects()");
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();

			while (DatabaseUtil.rs.next()) {
				SubjectModel subject = new SubjectModel();
				subject.setSubID(DatabaseUtil.rs.getInt("subID"));
				subject.setSubName(DatabaseUtil.rs.getString("subName"));
				subject.setSubCode(DatabaseUtil.rs.getString("subCode"));
				subject.setSubSyllabus(DatabaseUtil.rs.getString("subSyllabus"));
				subject.setSemID(DatabaseUtil.rs.getInt("semID"));
				subjects.add(subject);
				flag = 1;
				LogMessage
						.log("Message From UserDAO.login : subID is "
								+ subject.getSubID() + " subCode:"
								+ subject.getSubCode() + " subName:"
								+ subject.getSubName() + " semID:"
								+ subject.getSemID());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in AdminDAO.login");
			e.printStackTrace();
			subjects = null;
		} finally {
			if (flag != 1)
				subjects = null;
			DatabaseUtil.connectionClose();
		}

		return subjects;
	}

	public ArrayList<FacultyModel> getFaculties() {
		ArrayList<FacultyModel> faculties = new ArrayList<FacultyModel>();
		DatabaseUtil.connect();
		int flag = 0;
		try {
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from faculty");
			LogMessage
					.log("Message From AssignFacultySubjectDAO.login getFaculties() method");
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();

			while (DatabaseUtil.rs.next()) {
				FacultyModel faculty = new FacultyModel();
				faculty.setFacID(DatabaseUtil.rs.getInt("facID"));
				faculty.setFacName(DatabaseUtil.rs.getString("facName"));
				faculties.add(faculty);
				flag = 1;
				LogMessage.log("Message From UserDAO.login : subID is "
						+ faculty.getFacID() + " facCode:"
						+ faculty.getFacName() + " facName:");
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in AdminDAO.login");
			e.printStackTrace();
			faculties = null;
		} finally {
			if (flag != 1)
				faculties = null;
			DatabaseUtil.connectionClose();
		}

		return faculties;
	}

	/**
	 * This method returns true if the
	 */
	public boolean assignFacSub(int facID, int subID) {
		String query = "insert into mapSubjectFaculty (subID, facID) values ("
				+ subID + "," + facID + ")";
		int rowcount = BaseDAO.update(query);
		boolean output = false;
		LogMessage.log("Query: " + query + " rowcount:" + rowcount);
		if (rowcount > 0) {
			output = true;
		}
		return output;
	}
}
