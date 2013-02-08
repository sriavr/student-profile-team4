package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.studentProfile.model.entity.AnouncementsModel;
import com.studentProfile.model.entity.SemesterModel;

public class ManageAnouncementsDAO extends BaseDAO {
	
	public ArrayList<AnouncementsModel> getAnouncements()
	{
		String query = "select anoID,anoName from anouncements";
		 ArrayList<AnouncementsModel> anounceMents = new ArrayList<AnouncementsModel>();
		 ResultSet rs=readFromDB(query);
		 try
		 {
		 while(rs.next())
		 {
			 AnouncementsModel anouncementsModel =  new AnouncementsModel();
			 anouncementsModel.setAnoID(rs.getInt(1)+"");
			 anouncementsModel.setAnoName(rs.getString(2));
			 anounceMents.add(anouncementsModel);
			 
		 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 
		 }
		 finally
		 {
			 close(rs);
		 }
		 return anounceMents;
		
	}
	
	public void saveAnouncements(ArrayList<AnouncementsModel> anouncements)
	{
		String updateQuery="";
		for(AnouncementsModel anouncement:anouncements)
		{
			System.out.println(anouncement.isSelected());
			if(anouncement.isSelected())
			{
				if(anouncement.getAnoID().equals("0"))
				{
					updateQuery = "insert into anouncements(anoName) values('"+anouncement.getAnoName()+"')";
					System.out.println("updateQuery:"+updateQuery);
				    System.out.println(update(updateQuery));	
					
				}
				else
				{
					updateQuery = "update anouncements set anoName='"+anouncement.getAnoName()+"'";
					updateQuery +=" where anoID="+anouncement.getAnoID();
					System.out.println(update(updateQuery));
					
					
				}
				
			}
			
		}
		
	}
	
	public void deleteAnouncements(ArrayList<AnouncementsModel> anouncements)
	{
		String updateQuery="";
		for(AnouncementsModel anouncement:anouncements)
		{
			System.out.println(anouncement.isSelected());
			if(anouncement.isSelected())
			{
				
					updateQuery = "delete from anouncements";
					updateQuery +=" where anoID="+anouncement.getAnoID();
					System.out.println(update(updateQuery));
					
					
				
				
			}
			
		}
		
	}

}
