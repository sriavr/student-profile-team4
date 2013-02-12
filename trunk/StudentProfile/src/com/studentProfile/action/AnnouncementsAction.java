package com.studentProfile.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.AnnouncementsDAO;

public class AnnouncementsAction extends ActionSupport{

	//Inserts announcements list into session
	public String execute(){
		AnnouncementsDAO announcementsDAO = new AnnouncementsDAO();
		Map<String,Object> sessionMap=ActionContext.getContext().getSession();
		ArrayList<String> announcementsList=announcementsDAO.getAnnouncements();
		sessionMap.put("announcementsList", announcementsList);
		return Action.SUCCESS;
	}
}
