package com.studentProfile.DAO;

import com.studentProfile.util.LogMessage;

public class AddFacultyDAO {

	public boolean addFaculty(String facName) {
		String query = "insert into faculty (facName) values ('" + facName
				+ "')";
		int rowcount = BaseDAO.update(query);
		boolean output = false;
		LogMessage.log("Query: " + query + " rowcount:" + rowcount);
		if (rowcount > 0) {
			output = true;
		}
		return output;
	}
}
