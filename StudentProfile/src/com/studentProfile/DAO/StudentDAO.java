package com.studentProfile.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Blob;
import com.studentProfile.model.entity.*;
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
					.prepareStatement("select * from student where stuName=? and stuPassword=?");
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
				Blob blob = (Blob) DatabaseUtil.rs.getBlob("stuPhoto");
				if (blob != null)
					student.setStuPhoto(blob.getBytes(1, (int) blob.length()));
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
								+ student.getStuRollNo());
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

	// Added by Pavan
	public StudentModel getStudent(int stu_ID) {
		StudentModel student = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select * from student s where stuID=?");
			LogMessage
					.log("Message From StudentDAO.login : Arguments ::stu id is--"
							+ stu_ID);// " password is--" + password);
			DatabaseUtil.ps.setInt(1, stu_ID);
			// DatabaseUtil.ps.setString(2, password);
			// DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				student = new StudentModel();
				student.setStuID(DatabaseUtil.rs.getInt("stuID"));
				student.setStuName(DatabaseUtil.rs.getString("stuName"));
				student.setStuPassword(DatabaseUtil.rs.getString("stuPassword"));
				student.setStuRollNo(DatabaseUtil.rs.getString("stuRollNo"));
				student.setStuDOB(DatabaseUtil.rs.getDate("stuDOB"));
				Blob blob = (Blob) DatabaseUtil.rs.getBlob("stuPhoto");
				if (blob != null)
					student.setStuPhoto(blob.getBytes(1, (int) blob.length()));
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
			LogMessage.log("Exception Caught in studentDAO.getStudent");
			e.printStackTrace();
			student = null;
		} finally {
			if (flag != 1)
				student = null;
			DatabaseUtil.connectionClose();
		}

		return student;
	}

	public ArrayList<StudentModel> allStudents() {

		ArrayList<StudentModel> Students = new ArrayList<StudentModel>();
		StudentModel student;
		ResultSet result;
		String query;
		try {
			query = "select * from student";
			result = BaseDAO.readFromDB(query);
			LogMessage
					.log("Message From StudentDAO.allStudents() : Arguments :: no");
			while (result.next()) {
				Integer stuID = result.getInt("stuID");
				String stuName = result.getString("stuName");
				String stuPassword = result.getString("stuPassword");
				// File stuPhoto = result.getBlob("stuPhoto");
				byte stuPhoto[] = null;
				// String stuLoggedIn =
				// result.getTime("stuLoggedIn").toString();
				Date stuLoggedIn = null;
				String stuRollNo = result.getString("stuRollNo");
				Date stuDOB = result.getDate("stuDOB");
				student = new StudentModel(stuID, stuName, stuPhoto,
						stuPassword, stuLoggedIn, stuRollNo, stuDOB);
				Students.add(student);
			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.allStudents()");
			e.printStackTrace();
		}
		return Students;
	}

	public int getMaxStudentId() {
		int maxId = 0;
		String query;
		ResultSet result;
		try {
			query = " select max(stuID) as maxId from student;";
			result = BaseDAO.readFromDB(query);
			LogMessage
					.log("Message From StudentDAO.getMaxStudentId() : Arguments :: no");
			while (result.next()) {
				maxId = result.getInt("maxId");
			}
		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.getMaxStudentId()");
			e.printStackTrace();
		}
		return maxId;
	}

	public boolean updateStudentDetails(int stuID, String stuName,
			String stuPassword) {
		String query;
		boolean result = false;
		try {
			query = "update student set stuName = '" + stuName
					+ "',stuPassword = '" + stuPassword + "' where stuID="
					+ stuID;
			BaseDAO.update(query);
			LogMessage
					.log("Message From StudentDAO.updateStudentDetails() Arguments :: stuID : "
							+ stuID
							+ " stuName : "
							+ stuName
							+ " stuPassword : " + stuPassword);
			result = true;
			return result;
		} catch (Exception e) {
			LogMessage
					.log("Exception Caught in studentDAO.updateStudentDetails()");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean insertNewStudent(int stuID, String stuName,
			String stuPassword, String StuRollNo) {
		String query;
		boolean result = false;
		try {

			query = "insert into student(stuID,stuName,stuPassword,stuRollNo)"
					+ "values(" + stuID + ",'" + stuName + "','" + stuPassword
					+ "','" + StuRollNo + "')";

			BaseDAO.update(query);
			LogMessage
					.log("Message From StudentDAO.insertNewStudent() Arguments :: stuID : "
							+ stuID
							+ " stuName : "
							+ stuName
							+ " stuPassword : " + stuPassword);
			result = true;
			return result;

		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.insertNewStudent()");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean removeStudent(int stuID) {
		String query;
		boolean result = false;
		try {
			query = "delete from student where stuID=" + stuID;
			BaseDAO.update(query);
			LogMessage
					.log("Message From StudentDAO.removeStudent() Arguments :: stuID : "
							+ stuID);
			result = true;
			return result;
		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.removeStudent()");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public StudentModel getStudentDetails(int stuID) {

		String query;
		ResultSet result;
		StudentModel student = null;
		try {
			System.out.println("stuid : " + stuID);
			query = "select * from student where stuID=" + stuID;
			result = BaseDAO.readFromDB(query);
			LogMessage
					.log("Message From StudentDAO.getStudentDetails() : Arguments :: stuID : "
							+ stuID);
			while (result.next()) {
				Integer stuid = result.getInt("stuID");
				String stuName = result.getString("stuName");
				String stuPassword = result.getString("stuPassword");
				// File stuPhoto = result.getBlob("stuPhoto");
				byte stuPhoto[] = null;
				// String stuLoggedIn =
				// result.getTime("stuLoggedIn").toString();
				Date stuLoggedIn = null;
				String stuRollNo = result.getString("stuRollNo");
				Date stuDOB = result.getDate("stuDOB");
				student = new StudentModel(stuid, stuName, stuPhoto,
						stuPassword, stuLoggedIn, stuRollNo, stuDOB);
			}
		} catch (Exception e) {
			LogMessage
					.log("Exception Caught in studentDAO.getStudentDetails()");
			e.printStackTrace();
		}
		return student;
	}

	public boolean updateProfile(StudentModel studDetails) {
		boolean result = false;
		try {
			System.out.println("stuName:" + studDetails.getStuName());
			// System.out.println("stuPhoto: " +
			// studDetails.getStuPhoto().toString());
			PreparedStatement pst = BaseDAO.getConnection().prepareStatement(
					"update  student set stuPhoto=? WHERE stuID="
							+ studDetails.getStuID());
			pst.setBytes(1, studDetails.getStuPhoto());
			pst.executeUpdate();
			// BaseDAO.update(query);
			LogMessage
					.log("Message From StudentDAO.updateProfile() Arguments :: studDetails Object");
			result = true;
			return result;
		} catch (Exception e) {
			LogMessage.log("Exception Caught in studentDAO.updateProfile()");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
