package com.studentProfile.DAO;

import java.sql.ResultSet;

public class UpdateGradesDAO extends BaseDAO {

	/**
	 * @param args
	 */
	

	public ResultSet getStudentID(String query1) {
		// TODO Auto-generated method stub
		ResultSet rs;
		
		rs=BaseDAO.readFromDB(query1);
		
		return rs;
	}

	public ResultSet getSubjectID(String query2) {
		// TODO Auto-generated method stub
		ResultSet rs;
		
		rs=BaseDAO.readFromDB(query2);
		
		return rs;
		
	}

	public int updateGrades(String query4) {
		// TODO Auto-generated method stub
		int x=BaseDAO.update(query4);
		return x;
	}

	public ResultSet getSubjectIDfromStudentID(String query3) {
		// TODO Auto-generated method stub
		ResultSet rs;
			
		rs=BaseDAO.readFromDB(query3);
		
		return rs;
	}

}
