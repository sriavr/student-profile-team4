/**
 * SubjectModel.java
 * Date : 4 Feb 2013
 */
package com.studentProfile.model;

/**
 * @author Pratibind Kumar Jha
 * 
 *         Model of subject
 */
public class SubjectModel {

	
	private int subID;
	private String subCode;
	private String subName;
	private String subSyllabus;
	private int semID;
	private int facID;

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
	 * @return the facID
	 */
	public int getFacID() {
		return facID;
	}

	/**
	 * @param facID
	 *            the facID to set
	 */
	public void setFacID(int facID) {
		this.facID = facID;
	}

}
