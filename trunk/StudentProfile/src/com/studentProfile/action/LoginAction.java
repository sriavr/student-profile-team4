package com.studentProfile.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.AdminDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.AdminModel;
import com.studentProfile.model.entity.StudentModel;

public class LoginAction extends ActionSupport {

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * This method handles the login of administrator and student
	 */

	public String execute() {
		Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
		AdminDAO adminDAO = new AdminDAO();
		StudentDAO studentDAO = new StudentDAO();

		AdminModel admin = adminDAO.login(userName, password);
		if (admin != null) {
			sessionMap.put("admin", admin);
			sessionMap.put("role", "admin");
			return "adminLoginSuccess";
		} else {
			StudentModel student = studentDAO.login(userName, password);
			if (student == null) {
				addActionError("Wrong username/password combination");
				return "login";
			} else {
				sessionMap.put("student", student);
				sessionMap.put("role", "student");
				return "studentLoginSuccess";
			}
		}
	}
	/*
	 * public String execute() { UserDAO userDAO = new UserDAO(); Map<String,
	 * Object> sessionMap = ActionContext.getContext() .getSession();
	 * 
	 * UserModel user = userDAO.login(userName, password); // Here first we
	 * check in the admin table. If the user is valid, then we // redirect to
	 * admin homepage if (user != null) { sessionMap.put("user", user);
	 * 
	 * if (user.getRole().equals("admin")) { return "adminLoginSuccess"; } else
	 * if (user.getRole().equals("student")) { StudentDAO studentDAO = new
	 * StudentDAO(); StudentModel student = studentDAO.login(userName,
	 * password);
	 * 
	 * // If the user trying to log in is not an admin, we check the //
	 * credentials in student table. If the credentials are valid, // the user
	 * is redirected to student home page. if (student != null) {
	 * sessionMap.put("student", student); } return "studentLoginSuccess"; }
	 * else { return ERROR; }
	 * 
	 * } // If the user credentials are not valid, the user is redirected to an
	 * // error page return Action.ERROR; }
	 */

}
