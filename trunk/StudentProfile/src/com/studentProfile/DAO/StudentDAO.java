package com.studentProfile.DAO;

import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class StudentDAO {
	// This method validates the student credentials. If valid, returns a
	// student object else returns null
	public StudentModel login(String userName, String password) {
		StudentModel student = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from student s where stuName=? and stuPassword=?");
			LogMessage
					.log("Message From StudentDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				student = new StudentModel();
				student.setStuID(DatabaseUtil.rs.getInt("stuID"));
				student.setStuName(DatabaseUtil.rs.getString("stuName"));
				student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				student.setStuRollNo(DatabaseUtil.rs.getString("stuRollNo"));
				student.setStuDOB(DatabaseUtil.rs.getDate("stuDOB"));

				// student.setIntID(DatabaseUtil.rs.getInt("intID"));
				// student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				// ---------------- Yet to be
				// implemented-------------------------------
				// student.setStuLoggedIn(DatabaseUtil.rs.getTime("stuLoggedIn"));
				// student.setStuPhoto(DatabaseUtil.rs.getBlob("stuPhoto"));
				// ----------------
				// ----------------------------------------------------
				flag = 1;// setting flag = 1 says that a student credentials are
							// validated and there is an student with the given
							// credentials
				LogMessage
						.log("Message From studentDAO.login : student Name is "
								+ student.getStuName() + " RollNo:"
								+ student.getStuRollNo() + " username:");
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
