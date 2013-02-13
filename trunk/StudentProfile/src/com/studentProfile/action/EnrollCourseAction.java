/**
 * 	File Name	:	EnrollCourseAction.java
 * 	Description	:	Show the list of sem in enrollCourse.jsp and after Clicking the Enroll
 * 					button Enroll the student to all selected Checkbox of the subject.
 * Author		:	Pratibind Jha
 * Created Date	:	4 Feb 2013  
 */
package com.studentProfile.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.EnrollCourseDAO;
import com.studentProfile.model.entity.SemesterModel;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.model.entity.SubjectModel;

public class EnrollCourseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Semester ID
	private int semID;

	// Enroll button name
	private String enrollButton = "";

	// list of subject id that has been selected by student.
	private List<Integer> selectedCourse;

	// ArrayList of Semester Model.
	private ArrayList<SemesterModel> sem = new ArrayList<SemesterModel>();

	// ArrayList of subject
	private ArrayList<SubjectModel> subject = new ArrayList<SubjectModel>();

	/**
	 * @return the semID
	 */
	public int getSemID() {
		return semID;
	}

	/**
	 * @param semID
	 *            the semID to set
	 */
	public void setSemID(int semID) {
		this.semID = semID;
	}

	/**
	 * @return the enrollButton
	 */
	public String getEnrollButton() {
		return enrollButton;
	}

	/**
	 * @param enrollButton
	 *            the enrollButton to set
	 */
	public void setEnrollButton(String enrollButton) {
		this.enrollButton = enrollButton;
	}

	/**
	 * @return the selectedCourse
	 */
	public List<Integer> getSelectedCourse() {
		return selectedCourse;
	}

	/**
	 * @param selectedCourse
	 *            the selectedCourse to set
	 */
	public void setSelectedCourse(List<Integer> selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	/**
	 * @return the sem
	 */
	public ArrayList<SemesterModel> getSem() {
		return sem;
	}

	/**
	 * @param sem
	 *            the sem to set
	 */
	public void setSem(ArrayList<SemesterModel> sem) {
		this.sem = sem;
	}

	/**
	 * @return the subject
	 */
	public ArrayList<SubjectModel> getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(ArrayList<SubjectModel> subject) {
		this.subject = subject;
	}

	// show the list of semester in enrollCourse.jsp page action name is
	// "enrollCourseShowSemAction"
	public String showSemester() {
		this.setEnrollButton("showSemester");
		this.setSem(EnrollCourseDAO.showSemInfo());
		if (this.sem.isEmpty()) {
			addActionError("Semester id Empty");
			addActionMessage("No semester Exist as of now");
			return "error";
		}
		return "success";
	}

	// show the all subject of perticluar semester action Name is
	// "enrollCourseShowCourseAction"
	public String showSubject() {
		// action for Enroll.
		this.setSem(EnrollCourseDAO.showSemInfo());
		System.out.println("enrollButton: " + this.getEnrollButton());
		if (this.getEnrollButton().equalsIgnoreCase("Submit")) {
			String msg = "";
			boolean flag = false;
			// check for student has selected the course or not.
			if (this.selectedCourse.size() == 0) {
				addActionMessage("Please select the subject");
				return "success";
			}
			Map<String, Object> session;
			int studentID;
			String role="";
			//studentID = 2;
			
			// get the user information from session object.
			session = ActionContext.getContext().getSession();
			role = (String)session.get("role");
			StudentModel student = (StudentModel) session.get("student");
			if (role.equalsIgnoreCase("student")) {
				studentID = student.getStuID();
				System.out.println("Roll is: "+ role+" Student ID "+ studentID);
			} else {
				addActionMessage("There is no subject for Admin");
				return "success";
			}
			
			
			for (int i = 0; i < this.selectedCourse.size(); i++) {
				System.out.println(this.selectedCourse.get(i));
				msg = msg + this.selectedCourse.get(i) + ",";
				int status = EnrollCourseDAO.enrollStudent(
						this.selectedCourse.get(i), studentID);
				if (status != 0) {
					System.out.println("Enroll sucessfull: subID: "
							+ this.selectedCourse.get(i) + " stuID: "
							+ studentID);
					flag = true;
				} else
					flag = false;
			}
			if (flag) {
				addActionMessage("you have Enrolled  successfuly " + msg);
				return "success";
			} else {
				addActionMessage("Error occured....");
				return "error";
			}

		}// end of if.
			// action to show List of subject
		else {
			this.setEnrollButton("showSubject");
			System.out.println("SemID id :" + this.getSemID());
			if (this.getSemID() == -1) {
				addActionMessage("Please Select Semester");
				return "success";
			}
			this.setSubject(EnrollCourseDAO.showSubjectInfo(this.getSemID()));
			if (this.subject.isEmpty()) {
				System.out.println("subject is Empty");
				addActionError("There is no subject for this semster");
				addActionMessage("No subject Exist as of now");
				return "error";
			}

			System.out.println("enrollButton: " + this.getEnrollButton());
			return "success";

		}// End of else.
	}// End of showSubject().
}