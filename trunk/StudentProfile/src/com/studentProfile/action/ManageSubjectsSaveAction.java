package com.studentProfile.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.ManageSubjectsDAO;
import com.studentProfile.model.entity.SubjectModel;

public class ManageSubjectsSaveAction extends ActionSupport {
	
	ArrayList<SubjectModel> subjectList = new ArrayList<SubjectModel>();
	
	public ArrayList<SubjectModel> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<SubjectModel> subjectList) {
		this.subjectList = subjectList;
	}



	private String button;

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	
	
	public String execute()
	{
		ManageSubjectsDAO dao = new ManageSubjectsDAO();
		for(SubjectModel subModel:subjectList)
		{
			if(subModel.isSelected())
			{
				if(button.equals("Save"))
				{	
				if(subModel.getSubID()==0)
					dao.addSubject(subModel);
				else
					dao.updateSubject(subModel);
				}
				else
				{
					
					dao.deleteSubject(subModel.getSubID());
				}	
			}
			
		}
		
		return SUCCESS;
		
	}
	
	

}
