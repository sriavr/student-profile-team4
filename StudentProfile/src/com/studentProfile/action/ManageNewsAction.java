package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageNewsDAO;
import com.studentProfile.model.entity.NewsModel;

public class ManageNewsAction extends ActionSupport {
	
	ArrayList<NewsModel> newlist = new ArrayList<NewsModel>();

	
	public ArrayList<NewsModel> getNewlist() {
		return newlist;
	}


	public void setNewlist(ArrayList<NewsModel> newlist) {
		this.newlist = newlist;
	}


	public String execute()
	{
		ManageNewsDAO  dao = new ManageNewsDAO();
		
		setNewlist(dao.getNews());
		
		return SUCCESS;
		
	}

}
