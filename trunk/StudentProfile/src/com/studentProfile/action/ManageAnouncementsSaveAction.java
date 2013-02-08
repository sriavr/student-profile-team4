package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageAnouncementsDAO;
import com.studentProfile.model.entity.AnouncementsModel;

public class ManageAnouncementsSaveAction extends ActionSupport {
	
	ArrayList<AnouncementsModel> anouncements = new ArrayList<AnouncementsModel>();
	String button="";
	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public ArrayList<AnouncementsModel> getAnouncements() {
		return anouncements;
	}

	public void setAnouncements(ArrayList<AnouncementsModel> anouncements) {
		this.anouncements = anouncements;
	}

	public String execute()
	{
		ManageAnouncementsDAO dao = new ManageAnouncementsDAO();
		if(getButton().equals("Save"))
		 dao.saveAnouncements(anouncements);
		else
		 dao.deleteAnouncements(anouncements);	
		return SUCCESS;
	}

}
