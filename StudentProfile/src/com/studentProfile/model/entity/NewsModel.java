package com.studentProfile.model.entity;

public class NewsModel {
	
	private String newID;
	private boolean selected;
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getNewID() {
		return newID;
	}
	public void setNewID(String newID) {
		this.newID = newID;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	private String newName;

}
