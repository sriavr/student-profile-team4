package com.studentProfile.DAO;

import com.studentProfile.model.StudentModel;
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
					.prepareStatement("select * from user u, student s where s.usrID = u.usrID and u.usrName = ? and u.password = ?");
			LogMessage
					.log("Message From StudentDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				student = new StudentModel();
				student.setStuID(DatabaseUtil.rs.getInt("stuID"));
				student.setStuDOB(DatabaseUtil.rs.getDate("stuDOB"));
				student.setStuRollNo(DatabaseUtil.rs.getString("stuRollNo"));
				student.setStuName(DatabaseUtil.rs.getString("stuName"));
				// student.setIntID(DatabaseUtil.rs.getInt("intID"));
				// student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				// ---------------- Yet to be
				// implemented-------------------------------
				// student.setStuLoggedIn(DatabaseUtil.rs.getTime("stuLoggedIn"));
				// student.setStuPhoto(DatabaseUtil.rs.getBlob("stuPhoto"));
				// ----------------
				// ----------------------------------------------------
				student.getUser().setUsrName(
						DatabaseUtil.rs.getString("usrName"));
				student.getUser().setUsrID(DatabaseUtil.rs.getInt("s.usrID"));
				student.getUser().setPassword(
						DatabaseUtil.rs.getString("password"));
				student.getUser().setRole(DatabaseUtil.rs.getString("role"));

				flag = 1;// setting flag = 1 says that a student credentials are
							// validated and there is an student with the given
							// credentials
				LogMessage
						.log("Message From studentDAO.login : student Name is "
								+ student.getStuName() + " RollNo:"
								+ student.getStuRollNo() + " username:"
								+ student.getUser().getUsrName() + " role:"
								+ student.getUser().getRole());
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
