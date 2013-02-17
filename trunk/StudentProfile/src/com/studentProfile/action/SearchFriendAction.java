package com.studentProfile.action;

import com.studentProfile.model.entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.SearchFriendDAO;
import com.studentProfile.util.LogMessage;

public class SearchFriendAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	String studentNumber;
	public String enableFlag = "";
	public boolean agreed = false;

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public int studentid;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String studentname;
	public String studentdob;
	public String studentinterest = "";
	public int interestid;
	public static String uname;

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentdob() {
		return studentdob;
	}

	public void setStudentdob(String studentdob) {
		this.studentdob = studentdob;
	}

	public String getStudentinterest() {
		return studentinterest;
	}

	public void setStudentinterest(String studentinterest) {
		this.studentinterest = studentinterest;
	}

	public int getInterestid() {
		return interestid;
	}

	public void setInterestid(int interestid) {
		this.interestid = interestid;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String execute() throws ClassNotFoundException {
		LogMessage.log("Inside execute()");
		String query1, query, query2, query3;
		ResultSet result1, result, result2, result3;
		Statement statement;
		Connection con = null;

		SearchFriendDAO searchFriendDAO = new SearchFriendDAO();
		try {

			query1 = " select * from student where stuRollNo='" + studentNumber
					+ "'";
			// DatabaseUtil.connect();
			result1 = searchFriendDAO.getStudentDetails(query1);
			// result1 = statement.executeQuery(query1);
			if (result1.next()) {
				studentid = result1.getInt(1);
				studentname = result1.getString(2);
				studentdob = result1.getString(7);
				System.out.println("student name  " + studentname);
			}

			uname = studentname;

			// ///////////////////////////////////////////////////////////////////

			query = "SELECT intName from mapStudentInterests,interests WHERE mapStudentInterests.stuID="
					+ studentid
					+ " AND mapStudentInterests.intID=interests.intID";

			// query = "select intID from mapStudentInterests where stuID="
			// + studentid;

			result = searchFriendDAO.getStudentInterests(query);

			// //////////////////////////////////////////////////////////////////////

			ArrayList<String> studentinterestList = new ArrayList<String>();
			while (result.next()) {

				String interest = result.getString(1);
				System.out.println("Interest = " + interest);
				studentinterestList.add(interest);
			}
			for (String string : studentinterestList) {
				if (string.equals(null))
					continue;
				studentinterest += string + ",";
			}
			LogMessage.log("in SearchFriendAction: studentinterest-"
					+ studentinterest);
			if (studentinterest.length() > 0)
				studentinterest = studentinterest.substring(0,
						studentinterest.length() - 1);
			System.out.println("I am here");
			// ////////////////////////////////////////////////////////////////////

			Map<String, Object> sessionMap = ActionContext.getContext()
					.getSession();

			int loggedInStudentID = ((StudentModel) sessionMap.get("student"))
					.getStuID();
			query3 = "(select distinct stuID from friend,student where stuID1 = "
					+ loggedInStudentID
					+ " and stuID2=stuID) UNION (select distinct stuID from friend,student where stuID2 = "
					+ loggedInStudentID + " and stuID=stuID1)";
			// query3 =
			// "(select distinct stuID from friend,student where stuID1 = 1 and stuID2=stuID) UNION (select distinct stuID from friend,student where stuID2 = 1 and stuID=stuID1)";

			// result3 = statement.executeQuery(query3);
			System.out.println("Just executed");
			result = searchFriendDAO.verifyFriend(query3);
			while (result.next()) {
				int id = result.getInt("stuID");
				if (studentid == id) {
					enableFlag = "disabled";
					agreed = true;
					break;
				}

			}
			System.out.println(enableFlag);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";

	}

	public String addFriend() throws ClassNotFoundException {
		LogMessage.log("Inside addFriend()");

		String query, query1;
		ResultSet result;
		Statement statement;
		Connection con = null;
		SearchFriendDAO searchFriendDAO = new SearchFriendDAO();

		try {

			System.out.println("testing the program");

			// ////////////////////////////////////////////////////////////////////////////

			if (uname != null) {
				query = " select stuID from student where stuName='" + uname
						+ "'";
				LogMessage.log("Query for selecting student: " + query);
				// DatabaseUtil.connect();
				// result = statement.executeQuery(query);
				result = searchFriendDAO.getStudentID(query);
				if (result.next()) {
					studentid = result.getInt(1);
				}
				Map<String, Object> sessionMap = ActionContext.getContext()
						.getSession();

				int loggedInStudentID = ((StudentModel) sessionMap
						.get("student")).getStuID();
				// //////////////////////////////////////////////////////////////////////////////
				if (studentid != 0) {
					query1 = " insert into friend(stuID2,stuID1) values("
							+ loggedInStudentID + "," + studentid + ")";
					LogMessage.log("Executing query:" + query1);
					// DatabaseUtil.connect();

					searchFriendDAO.updateFriend(query1);
					// statement.executeUpdate(query1);
				}
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";

	}

	public String removeFriend() throws ClassNotFoundException {
		LogMessage.log("Inside removeFriend()");
		String query, query1;
		ResultSet result;

		SearchFriendDAO searchFriendDAO = new SearchFriendDAO();
		try {

			System.out.println("testing the program");

			// /////////////////////////////////////////////////////////////////

			query = " select stuID from student where stuName='" + uname + "'";
			LogMessage.log(query);
			// DatabaseUtil.connect();
			// result = statement.executeQuery(query1);
			result = searchFriendDAO.getStudentID(query);
			if (result.next()) {
				studentid = result.getInt(1);
			}

			// ////////////////////////////////////////////////////////////////////

			Map<String, Object> sessionMap = ActionContext.getContext()
					.getSession();

			int loggedInStudentID = ((StudentModel) sessionMap.get("student"))
					.getStuID();

			query1 = " delete from friend where stuID2=" + loggedInStudentID
					+ " and stuID1=" + studentid;
			query1 += "  or (stuID1=" + loggedInStudentID + " and stuID2="
					+ studentid + ")";
			// DatabaseUtil.connect();

			searchFriendDAO.updateDelete(query1);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";

	}

}
