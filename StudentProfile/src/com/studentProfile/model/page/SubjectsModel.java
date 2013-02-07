/**
 * SubjectsModel.java
 * date: feb 7, 2013 
 */
package com.studentProfile.model.page;

/**
 * @author Pratibind Kumar Jha
 * 
 */
public class SubjectsModel {

	private int subID;
	private String subCode;
	private String subName;
	private String subSyllabus;
	private String facName;
	private String semName;
	private String isEnroll;
	private String enrGrade;
	private int stuID;

	/**
	 * @return the stuID
	 */
	public int getStuID() {
		return stuID;
	}

	/**
	 * @param stuID
	 *            the stuID to set
	 */
	public void setStuID(int stuID) {
		this.stuID = stuID;
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
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @param subName
	 *            the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
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
	 * @return the facName
	 */
	public String getFacName() {
		return facName;
	}

	/**
	 * @param facName
	 *            the facName to set
	 */
	public void setFacName(String facName) {
		this.facName = facName;
	}

	/**
	 * @return the semName
	 */
	public String getSemName() {
		return semName;
	}

	/**
	 * @param semName
	 *            the semName to set
	 */
	public void setSemName(String semName) {
		this.semName = semName;
	}

	/**
	 * @return the isEnroll
	 */
	public String getIsEnroll() {
		return isEnroll;
	}

	/**
	 * @param isEnroll
	 *            the isEnroll to set
	 */
	public void setIsEnroll(String isEnroll) {
		this.isEnroll = isEnroll;
	}

	/**
	 * @return the enrGrade
	 */
	public String getEnrGrade() {
		return enrGrade;
	}

	/**
	 * @param enrGrade
	 *            the enrGrade to set
	 */
	public void setEnrGrade(String enrGrade) {
		this.enrGrade = enrGrade;
	}

}
