package com.studentProfile.DAO;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class MyFriendsDAO {
	// This method validates the student credentials. If valid, returns a
	// student object else returns null
	ArrayList<StudentModel> friendsList = new ArrayList<StudentModel>();

	public ArrayList<StudentModel> getFriends(int stuID) {
		StudentModel student = null;
		Blob image = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			// LogMessage.log("Message From MyFriendsDAO.MyFriendDAO : username is "
			// + student.getStuName());
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("(select distinct stuID,stuName,stuPhoto  from friend,student where stuID1 = ? and stuID2=stuID) UNION (select distinct stuID,stuName,stuPhoto from friend,student  where stuID2 = ? and stuID=stuID1)");
			LogMessage
					.log("Message From StudentDAO.login : Arguments ::username is--"
							+ stuID + " password is--");// + password);
			DatabaseUtil.ps.setInt(1, stuID);
			DatabaseUtil.ps.setInt(2, stuID);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				flag = 1;
				student = new StudentModel();
				student.setStuID(DatabaseUtil.rs.getInt("stuID"));
				// student.setIntID(DatabaseUtil.rs.getInt("intID"));
				System.out.println("stuID");
				student.setStuName(DatabaseUtil.rs.getString("stuName"));
				System.out.println("Stuname");
				// to convert picture from blob byte streams
				image = DatabaseUtil.rs.getBlob("stuPhoto");
				System.out.println("image length:" + image.length());
				student.setStuPhoto(image.getBytes(1, (int) image.length()));
				// student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				// student.setStuDOB(DatabaseUtil.rs.getDate("stuDOB"));
				// ---------------- Yet to be
				// implemented-------------------------------
				// student.setStuLoggedIn(DatabaseUtil.rs.getTime("stuLoggedIn"));
				// student.setStuPhoto(DatabaseUtil.rs.getBlob("stuPhoto"));
				// ----------------
				// ----------------------------------------------------
				// student.setStuRollNo(stuRollNo);
				friendsList.add(student);

			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in MyfriendsDAO.getFriends");
			e.printStackTrace();
			friendsList = null;
		} finally {
			if (flag != 1)
				friendsList = null;
			DatabaseUtil.connectionClose();
		}

		return friendsList;
	}

}
