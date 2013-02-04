package com.studentProfile.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.AdminDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.AdminModel;
import com.studentProfile.model.StudentModel;
import com.studentProfile.util.ConstantValues;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
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
		AdminDAO adminDAO = new AdminDAO();
		Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
		AdminModel admin = adminDAO.login(userName, password);
		// Here first we check in the admin table. If the user is valid, then we
		// redirect to admin homepage
		if (admin != null) {
			sessionMap.put("user", admin);
			sessionMap.put("role", ConstantValues.administrator);
			return "adminLoginSuccess";
		} else {
			// If the user trying to log in is not an admin, we check the
			// credentials in student table. If the credentials are valid, the
			// user is redirected to student home page.
			StudentDAO studentDAO = new StudentDAO();
			StudentModel student = studentDAO.login(userName, password);
			if (student != null) {
				sessionMap.put("user", student);
				sessionMap.put("role", ConstantValues.student);
				return "studentLoginSuccess";
			}
		}
		//If the user credentials are not valid, the user is redirected to an error page
		return Action.ERROR;
	}

}
