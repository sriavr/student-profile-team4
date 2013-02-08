package com.studentProfile.model.entity;

public class AnouncementsModel {
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	private String anoID;
	private String anoName;
	public String getAnoID() {
		return anoID;
	}
	public void setAnoID(String anoID) {
		this.anoID = anoID;
	}
	public String getAnoName() {
		return anoName;
	}
	public void setAnoName(String anoName) {
		this.anoName = anoName;
	}

}
