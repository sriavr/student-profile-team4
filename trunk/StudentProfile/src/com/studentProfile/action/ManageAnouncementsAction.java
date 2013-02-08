package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageAnouncementsDAO;
import com.studentProfile.model.entity.AnouncementsModel;

public class ManageAnouncementsAction extends ActionSupport {
	
	ArrayList<AnouncementsModel> anouncements = new ArrayList<AnouncementsModel>();

	public ArrayList<AnouncementsModel> getAnouncements() {
		return anouncements;
	}

	public void setAnouncements(ArrayList<AnouncementsModel> anouncements) {
		this.anouncements = anouncements;
	}
	public String execute()
	{
		ManageAnouncementsDAO  dao = new ManageAnouncementsDAO();
		
		setAnouncements(dao.getAnouncements());
		return SUCCESS;
		
	}

}
