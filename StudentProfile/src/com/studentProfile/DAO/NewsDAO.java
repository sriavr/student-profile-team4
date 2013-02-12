package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentProfile.util.LogMessage;

public class NewsDAO extends BaseDAO{
	public ArrayList<String> getNews(){
		String query="SELECT * FROM news";
		ArrayList<String> newsList=new ArrayList<String>();
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				newsList.add(rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogMessage.log("Exception caught in newsDAO.getNews");
			e.printStackTrace();
		}finally{
			close(rs);
		}
		
		return newsList;
	}
}
