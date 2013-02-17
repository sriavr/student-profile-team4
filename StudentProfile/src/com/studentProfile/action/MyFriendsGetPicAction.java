package com.studentProfile.action;

import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.studentProfile.DAO.StudentDAO;
import com.studentProfile.model.entity.StudentModel;

public class MyFriendsGetPicAction extends ActionSupport {
	
	private String contentType="";
	private String stuID;
	private StudentModel model;
	private byte[] imageInBytes;
	private String contentDisposition="";
	private int contentLength;
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public StudentModel getModel() {
		return model;
	}

	public void setModel(StudentModel model) {
		this.model = model;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setImageInBytes(byte[] imageInBytes) {
		this.imageInBytes = imageInBytes;
	}

	public String getContentType() {
		
		return "image/jpg";
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public byte[] getImageInBytes() { 
		
		StudentDAO studentDAO = new StudentDAO();
		model = new StudentModel();

		System.out
				.println("the picture other profile of user_id" + getStuID());

		model = studentDAO.getStudent(Integer.parseInt(getStuID()));
		System.out.println("length of pic:"+model.getStuPhoto().length);
		return model.getStuPhoto();
		
	}

	
	  public String getContentDisposition() { 
        return "inline";
	  
	  }
	  public int getContentLength() { 
		  
		   return model.getStuPhoto().length;
		  
	  }
	  
	
	public String execute() {

		 
	    System.out.println("inside getImageAction..........");
	    setImageInBytes(getImageInBytes());
	    setContentLength(getContentLength());
	    setContentType(getContentType());
	    setContentLength(contentLength);

		return "myImageResult";
	}

}
