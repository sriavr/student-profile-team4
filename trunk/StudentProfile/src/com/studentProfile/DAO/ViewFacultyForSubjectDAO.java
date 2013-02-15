package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentProfile.model.entity.FacultyModel;
import com.studentProfile.util.LogMessage;

public class ViewFacultyForSubjectDAO {

	public ArrayList<FacultyModel> getFacultyList(int subID) {
		int flag = 0;
		ArrayList<FacultyModel> facultyList = new ArrayList<FacultyModel>();
		String query = "select f.facID, f.facName, m.subID from faculty f, mapSubjectFaculty m where m.facID = f.facID and m.subID ="
				+ subID;
		ResultSet rs = BaseDAO.readFromDB(query);
		try {
			while (rs.next()) {
				FacultyModel faculty = new FacultyModel();
				faculty.setFacID(rs.getInt("f.facId"));
				faculty.setFacName(rs.getString("f.facName"));
				flag = 1;
				facultyList.add(faculty);
			}
		} catch (SQLException e) {
			LogMessage
					.log("Exception Caught in ViewFacultyForSubjectDAO.getFacultyList");
			e.printStackTrace();
			return null;
		} finally {
			BaseDAO.close(rs);
			if (flag == 0) {
				return null;
			}
		}

		return facultyList;
	}
}
