package com.studentProfile.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.InterestDAO;
import com.studentProfile.model.entity.InterestModel;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.LogMessage;

public class MyProfileAction extends ActionSupport {
	private ArrayList<InterestModel> interests = new ArrayList<InterestModel>();
	Set<String> allInts;
	Set<String> pertInts;
	String hiddenStr=":";
	
	
	public String getHiddenStr() {
		return hiddenStr;
	}

	public void setHiddenStr(String hiddenStr) {
		this.hiddenStr = hiddenStr;
	}

	public Set<String> getAllInts() {
		return allInts;
	}

	public void setAllInts(Set<String> allInts) {
		this.allInts = allInts;
	}

	public Set<String> getPertInts() {
		return pertInts;
	}

	public void setPertInts(Set<String> pertInts) {
		this.pertInts = pertInts;
	}

	public ArrayList<InterestModel> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<InterestModel> interests) {
		this.interests = interests;
	}

	public String myProfile() {
		System.out.println("myprofile ()");
		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			return ERROR;
		}
		LogMessage
				.log("Message From MyProfileAction.myProfile : Arguments :: none");
		InterestDAO interestDAO = new InterestDAO();
		//get all interests 
		allInts = interestDAO.allInterests();
		System.out.println("set all Interests : " + allInts);
		//get Particular student Interests
		System.out.println("one");
		pertInts = interestDAO.getStudInterests(student
				.getStuID());
		System.out.println("two");
		if(pertInts != null){
			System.out.println("three");
			Iterator<String> iterator = pertInts.iterator(); 
			while(iterator.hasNext()) {
				String interest = (String) iterator.next();
				hiddenStr += interest+":";
			}
		}
		
		System.out.println("hidden string " + hiddenStr);
		System.out.println("set pert Interests : " + pertInts);
		if(pertInts != null){
			allInts.removeAll(pertInts);
		}
		System.out.println("set diff Interests : " + allInts);
		

		return Action.SUCCESS;
	}
}