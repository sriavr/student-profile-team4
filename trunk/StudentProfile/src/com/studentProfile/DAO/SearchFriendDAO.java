package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class SearchFriendDAO extends BaseDAO{

	/**
	 * @param args
	 */

	public ResultSet getStudentDetails(String query1) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		 
		rs = BaseDAO.readFromDB(query1);
		
		return rs;
	}



	public ResultSet getStudentInterests(String query) {
		// TODO Auto-generated method stub
//		ResultSet rs;
//		rs=
		return BaseDAO.readFromDB(query);
	}



	public ResultSet verifyFriend(String query) {
		// TODO Auto-generated method stub
		ResultSet rs;
		 System.out.println("query = "+query);
		rs = BaseDAO.readFromDB(query);
		System.out.println("Hello Babai");
		return rs;
	}



	public ResultSet getStudentID(String query) {
		// TODO Auto-generated method stub
		ResultSet rs;
		 
		rs = BaseDAO.readFromDB(query);
		
		return rs;
	}



	public void updateFriend(String query) {
		// TODO Auto-generated method stub
		
		 
		BaseDAO.update(query);
		
		
	}



	public void updateDelete(String query1) {
		// TODO Auto-generated method stub
		BaseDAO.update(query1);
		
	}


	}
	

