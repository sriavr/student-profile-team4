package com.studentProfile.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.util.LogMessage;

/**
 * 
 * @author sridhar
 * 
 */
public class LogoutAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
		LogMessage.log("Inside LogoutAction. Logging out...");
		sessionMap.remove("user");
		sessionMap.remove("student");
		return SUCCESS;
	}

}
