package com.studentProfile.DAO;

import com.studentProfile.model.StudentModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class StudentDAO {
	// This method validates the student credentials. If valid, returns a
	// student object else returns null
	public StudentModel login(String stuRollNo, String password) {
		StudentModel student = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("SELECT * FROM student WHERE stuRollNo=? AND stuPassword=?");
			LogMessage
					.log("Message From StudentDAO.login : Arguments ::username is--"
							+ stuRollNo + " password is--" + password);
			DatabaseUtil.ps.setString(1, stuRollNo);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				student = new StudentModel();
				student.setStuID(DatabaseUtil.rs.getInt("stuID"));
				student.setIntID(DatabaseUtil.rs.getInt("intID"));
				student.setStuName(DatabaseUtil.rs.getString("stuName"));
				student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				student.setStuDOB(DatabaseUtil.rs.getDate("stuDOB"));
				// ---------------- Yet to be
				// implemented-------------------------------
				// student.setStuLoggedIn(DatabaseUtil.rs.getTime("stuLoggedIn"));
				// student.setStuPhoto(DatabaseUtil.rs.getBlob("stuPhoto"));
				// ----------------
				// ----------------------------------------------------
				student.setStuRollNo(stuRollNo);
				flag = 1;// setting flag = 1 says that a student credentials are
							// validated and there is an student with the given
							// credentials
				LogMessage.log("Message From studentDAO.login : username is "
						+ student.getStuName());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.login");
			e.printStackTrace();
			student = null;
		} finally {
			if (flag != 1)
				student = null;
			DatabaseUtil.connectionClose();
		}

		return student;
	}

}
