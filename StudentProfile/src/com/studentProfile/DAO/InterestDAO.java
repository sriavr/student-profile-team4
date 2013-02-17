package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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
					.log("Message From StudentDAO.allStudents() : Arguments :: no");
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
			LogMessage.log("Exception Caught in studentDAO.allintersts()");
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

}
