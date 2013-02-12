package com.studentProfile.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.util.LogMessage;

/**
 * 
 * @author svkris
 * 
 *         Purpose of this class is sticking to the tiles pattern. Sometimes we
 *         have a necessity to call the jsp page directly like hyper linking a
 *         jsp page. In such cases confirming to tiles pattern becomes dificult.
 *         Hence one can create a forwardAction here and redirect to the page
 *         through this and stick to tiles :)
 */
public class ForwardAction extends ActionSupport {
	public String index() {
		LogMessage.log("Message From ForwardAction.index: I am here :)");
		return Action.SUCCESS;
	}

	public String login() {
		LogMessage.log("Message From ForwardAction.login: I am here :)");
		return Action.SUCCESS;
	}
	
	public String studentHome() {
		LogMessage.log("Message From ForwardAction.studentHome: I am here :)");
		return Action.SUCCESS;
	}
}
