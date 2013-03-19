package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.studentProfile.model.entity.InterestModel;
import com.studentProfile.util.LogMessage;

public class InterestDAO {

	public ArrayList<InterestModel> getInterests(Integer stuID) {
		ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
		InterestModel interest;
		ResultSet result;
		String query;
		int flag = 0;
		try {
			query = "select * from interests i, mapStudentInterests m where i.intID = m.intID and m.stuID = "
					+ stuID;
			result = BaseDAO.readFromDB(query);
			LogMessage.log("Executing query :" + query);
			LogMessage
					.log("Message From InterestDAO.getInterests() : Arguments :: stuID" +stuID);
			while (result.next()) {
				flag = 1;
				Integer intID = result.getInt("intID");
				String intName = result.getString("intName");
				interest = new InterestModel();
				interest.setIntID(intID);
				interest.setIntName(intName);
				interests.add(interest);
			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in InterestDAO.getInterests()");
			e.printStackTrace();
		} finally {
			if (flag == 0) {
				return null;
			}
		}
		return interests;
	}

	public boolean mapStudentInterest(int stuID, int intID) {
		String query = " insert into mapStudentInterests (stuID, intID) values ("
				+ stuID + "," + intID + ")";
		int rowcount = BaseDAO.update(query);
		boolean output = false;
		LogMessage.log("Query: " + query + " rowcount:" + rowcount);
		if (rowcount > 0) {
			output = true;
		}
		return output;
	}
	
	public Set<String> allInterests() {
		
		//ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
		Set<String> interests = new HashSet<String>();
		ResultSet result;
		String query;
		int flag = 0;
		try {
			query = "select * from interests";
			result = BaseDAO.readFromDB(query);
			LogMessage.log("Executing query :" + query);
			LogMessage
					.log("Message From InterestDAO.allInterests() : Arguments :: no");
			while (result.next()) {
				flag = 1;
				String intName = result.getString("intName");
				interests.add(intName);
			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in InterestDAO.allInterests()");
			e.printStackTrace();
		} finally {
			if (flag == 0) {
				return null;
			}
		}
		return interests;
	}
	
	public Set<String> getStudInterests(Integer stuID) {
		//ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
		Set<String> interests = new HashSet<String>();
		ResultSet result;
		String query;
		int flag = 0;
		try {
			query = "select i.intName from interests i, mapStudentInterests m where i.intID = m.intID and m.stuID = "
					+ stuID;
			result = BaseDAO.readFromDB(query);
			LogMessage.log("Executing query :" + query);
			LogMessage
					.log("Message From InterestDAO.getStudInterests() : Arguments :: stuID" +stuID);
			while (result.next()) {
				flag = 1;
				String intName = result.getString("intName");
				interests.add(intName);
			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in InterestDAO.getStudInterests()");
			e.printStackTrace();
		} finally {
			if (flag == 0) {
				return null;
			}
		}
		return interests;
	}

	public int getIntId(String interestName) {
		ResultSet result;
		String query;
		int intID = 0 ;
		try {
			query = "select intID from interests where intName='" + interestName + "'";
			result = BaseDAO.readFromDB(query);
			LogMessage.log("Executing query :" + query);
			LogMessage
					.log("Message From InterestDAO.getIntId() : Arguments :: interest Name " + interestName);
			while (result.next()) {
				 intID = result.getInt("intID");
			}
		}
		catch (Exception e) {
				LogMessage.log("Exception Caught in InterestDAO.getInterests()");
				e.printStackTrace();
		}
		return intID;
	}
	public void removeStudInterests(int studId) {
		ResultSet result;
		String query;
		int intID = 0 ;
		try {
			query = "delete from  mapStudentInterests where stuId = " + studId ;
			BaseDAO.update(query);
			LogMessage.log("Executing query :" + query);
			LogMessage
					.log("Message From InterestDAO.removeStudInterests() : Arguments :: StudentId " + studId);
		}
		catch (Exception e) {
				LogMessage.log("Exception Caught in InterestDAO.removeStudInterests()");
				e.printStackTrace();
		}
	
	}	
}
