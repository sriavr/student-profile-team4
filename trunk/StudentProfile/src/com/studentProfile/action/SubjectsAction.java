/**
 * SubjectsAction.java
 * Date	feb 7, 2013
 * DEscription	:	show the subject information subject name, 
 * 					faculty,grade,enroll and so. 
 */
package com.studentProfile.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.SubjectsDAO;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.model.page.SubjectsModel;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class SubjectsAction extends ActionSupport {

	private ArrayList<SubjectsModel> subjectsInfo;
	private int subID;
	private int course;
	private String subSyllabus = "";
	private String actionName = "";
	private String subCode;

	/**
	 * @return the subCode
	 */
	public String getSubCode() {
		return subCode;
	}

	/**
	 * @param subCode
	 *            the subCode to set
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName
	 *            the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the subSyllabus
	 */
	public String getSubSyllabus() {
		return subSyllabus;
	}

	/**
	 * @param subSyllabus
	 *            the subSyllabus to set
	 */
	public void setSubSyllabus(String subSyllabus) {
		this.subSyllabus = subSyllabus;
	}

	/**
	 * @return the course
	 */
	public int getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(int course) {
		this.course = course;
	}

	/**
	 * @return the subjectsInfo
	 */
	public ArrayList<SubjectsModel> getSubjectsInfo() {
		return subjectsInfo;
	}

	/**
	 * @param subjectsInfo
	 *            the subjectsInfo to set
	 */
	public void setSubjectsInfo(ArrayList<SubjectsModel> subjectsInfo) {
		this.subjectsInfo = subjectsInfo;
	}

	/**
	 * @return the subID
	 */
	public int getSubID() {
		return subID;
	}

	/**
	 * @param subID
	 *            the subID to set
	 */
	public void setSubID(int subID) {
		this.subID = subID;
	}

	// show subject Info into subjetcs.jsp page.
	public String showSubjectInfo() {

		if (this.getActionName().equalsIgnoreCase("showSyllabus")) {
			this.setActionName("subSyllabus");
			return "success";
		}
		this.setActionName("showSubject");
		int studentID;
		Map<String, Object> session;

		// get the user information from session object.
		//studentID = 1;
		String roll="";
		session = ActionContext.getContext().getSession();
		roll = (String)session.get("role");
		StudentModel student = (StudentModel) session.get("student");
		if (roll.equalsIgnoreCase("student")) {
			studentID = student.getStuID();
			System.out.println("Roll is: "+ roll+" Student ID "+ studentID);
		} else {
			addActionMessage("There is no subject for Admin");
			return "success";
		}
		

		this.setSubjectsInfo(SubjectsDAO.getSubjectInfo(this.getCourse(),
				studentID));

		if (this.getSubjectsInfo().isEmpty()) {
			addActionError("");
			addActionMessage("You have not Enroll to course");
			return "success";
		}
		return "success";

	}// End of showSubjectInfo().
}// End of SubjectAction.java
