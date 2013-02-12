package com.studentProfile.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.studentProfile.DAO.NewsDAO;

public class NewsAction {
	//Inserts news list into sesion
	public String execute(){
		NewsDAO newsDAO = new NewsDAO();
		Map<String,Object> sessionMap=ActionContext.getContext().getSession();
		ArrayList<String> newsList=newsDAO.getNews();
		sessionMap.put("newsList", newsList);
		return Action.SUCCESS;
	}
}
