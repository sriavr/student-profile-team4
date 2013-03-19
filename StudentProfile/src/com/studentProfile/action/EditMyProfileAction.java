package com.studentProfile.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.InterestDAO;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.InterestModel;
import com.studentProfile.model.entity.StudentModel;
import com.studentProfile.util.LogMessage;

public class EditMyProfileAction extends ActionSupport {

	Integer studentID;
	String studentName;
	File uploadPic;
	Date studentDOB;
	String[] checkedInterest;
	String hiddenStr;
	Set<String> updatedIntList;
	String interestString;
	

	public String getHiddenStr() {
		return hiddenStr;
	}

	public void setHiddenStr(String hiddenStr) {
		this.hiddenStr = hiddenStr;
	}

	public String[] getCheckedInterest() {
		return checkedInterest;
	}

	public void setCheckedInterest(String[] checkedInterest) {
		this.checkedInterest = checkedInterest;
	}

	StudentModel studDetails = new StudentModel();
	StudentDAO studDAO = new StudentDAO();

	
	public String editProfile() {
		InterestDAO intDAO = new InterestDAO();
		StudentModel student = (StudentModel) ActionContext.getContext()
				.getSession().get("student");
		if (student == null) {
			LogMessage.log("user not logged in possibly, student is null");
			return ERROR;
		}

		
		try {
//			LogMessage.log("selectedInterests:" + selectedInterests + " stuID:"
//					+ stuID + " studentID:" + studentID);
//
//			if (!selectedInterests.isEmpty()) {
//				String[] strInterests = selectedInterests.split(",");
//				int[] interests = new int[strInterests.length];
//				for (int i = 0; i < strInterests.length; i++) {
//					strInterests[i].trim();
//					interests[i] = Integer.parseInt(strInterests[i]);
//					intDAO.mapStudentInterest(stuID, interests[i]);
//				}
//			}
			studDetails.setStuID(getStudentID());
			studDetails.setStuName(getStudentName());
			studDetails.setStuDOB(getStudentDOB());
			System.out.println("in edit Profile() with stuid:"
					+ studDetails.getStuID() + "stuName:"
					+ studDetails.getStuName() + "dob:"
					+ studDetails.getStuDOB());
			byte[] picData = new byte[0];
			int flag = 0;
			if (this.getUploadPic() != null) {
				FileInputStream fs = new FileInputStream(this.getUploadPic());

				picData = org.apache.commons.io.IOUtils.toByteArray(fs);
				studDetails.setStuPhoto(picData);
				flag = 1;
			}
			//Interest checkboxes
			System.out.println("selected Int : ");
			String selectedInt[] = hiddenStr.split(":");
			updatedIntList = new HashSet<String>();
			for (int i = 1; i < selectedInt.length; i++) {
				System.out.println(selectedInt[i]);
				if(selectedInt[i].charAt(0)=='-')
					updatedIntList.remove(selectedInt[i].substring(1, selectedInt[i].length()));
					
				else
					updatedIntList.add(selectedInt[i]);
			}
			System.out.println("list " +updatedIntList);
			intDAO.removeStudInterests(studDetails.getStuID());
			Iterator<String> it = updatedIntList.iterator();
			while(it.hasNext()){
				String intName =  (String)it.next() ;
				int intId = intDAO.getIntId(intName);
				intDAO.mapStudentInterest(studDetails.getStuID(),intId);
			}
			System.out.println("intersted String" + interestString);
			//updatedInterests()
			studDAO.updateProfile(studDetails);
			
			if (flag != 0) {
				((StudentModel) ActionContext.getContext().getSession()
						.get("student")).setStuPhoto(picData);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public File getUploadPic() {
		return uploadPic;
	}

	public void setUploadPic(File uploadPic) {
		this.uploadPic = uploadPic;
	}

}