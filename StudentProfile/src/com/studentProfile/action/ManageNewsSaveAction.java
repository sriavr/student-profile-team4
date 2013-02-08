package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageNewsDAO;
import com.studentProfile.model.entity.NewsModel;

public class ManageNewsSaveAction extends ActionSupport {
	
	ArrayList<NewsModel> newlist = new ArrayList<NewsModel>();
	

	public ArrayList<NewsModel> getNewlist() {
		return newlist;
	}

	public void setNewlist(ArrayList<NewsModel> newlist) {
		this.newlist = newlist;
	}


	String button="";
	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	
	public String execute()
	{
		ManageNewsDAO dao = new ManageNewsDAO();
		if(getButton().equals("Save"))
		 dao.savenews(newlist);
		else
		 dao.deletenews(newlist);	
		return SUCCESS;
	}

}
