package com.studentProfile.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.LogMessage;

public class LeftPaneAction extends ActionSupport {

	public String execute() {
		return Action.SUCCESS;
	}

	public String profilePic() {
		LogMessage
		.log("Message From LeftPaneAction.profilePic : Arguments :: no");
		HttpServletResponse response = ServletActionContext.getResponse();
		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		response.setContentType("image/jpeg");
		try {
			OutputStream out = response.getOutputStream();
			if (student.getStuPhoto().length == 0) {
				//hard coded picture of blank image;
				//student.setStuPhoto(new byte[0]);
			} 
			else {
				//System.out.println(student.getStuPhoto()==null?"yes":"no");
				out.write(student.getStuPhoto());
			}
			out.close();
		} catch (Exception e) {
			LogMessage.log("Exception Caught in LeftPaneAction.profilePic");
			e.printStackTrace();
		}

		return null;
	}
}
