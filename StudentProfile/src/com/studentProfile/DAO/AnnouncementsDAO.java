package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentProfile.util.LogMessage;

 

public class AnnouncementsDAO extends BaseDAO{
	public ArrayList<String> getAnnouncements(){
		String query="SELECT * FROM anouncements";
		ArrayList<String> announcementsList=new ArrayList<String>();
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				announcementsList.add(rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogMessage.log("Exception caught in AnnouncementsDAO.getAnnouncements");
			e.printStackTrace();
		}finally{
			close(rs);
		}
		
		return announcementsList;
	}
}
