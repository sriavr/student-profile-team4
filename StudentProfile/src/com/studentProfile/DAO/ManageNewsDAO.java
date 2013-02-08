package com.studentProfile.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;


import com.studentProfile.model.entity.NewsModel;


public class ManageNewsDAO extends BaseDAO {
	
	public ArrayList<NewsModel> getNews()
	{
		String query = "select newID,newName from news";
		 ArrayList<NewsModel> news = new ArrayList<NewsModel>();
		 ResultSet rs=readFromDB(query);
		 try
		 {
		 while(rs.next())
		 {
			 NewsModel newsModel =  new NewsModel();
			 newsModel.setNewID(rs.getInt(1)+"");
			 newsModel.setNewName(rs.getString(2));
			 news.add(newsModel);
			 
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
		 System.out.println("new size:"+news.size());
		 return news;
		
	}
	
	public void savenews(ArrayList<NewsModel> news)
	{
		String updateQuery="";
		for(NewsModel anouncement:news)
		{
			System.out.println(anouncement.isSelected());
			if(anouncement.isSelected())
			{
				System.out.println(anouncement.getNewName());
				if(anouncement.getNewID().equals("0"))
				{
					updateQuery = "insert into news(newName) values('"+anouncement.getNewName()+"')";
					System.out.println("updateQuery:"+updateQuery);
				    System.out.println(update(updateQuery));	
					
				}
				else
				{
					updateQuery = "update news set newName='"+anouncement.getNewName()+"'";
					updateQuery +=" where newID="+anouncement.getNewID();
					System.out.println(update(updateQuery));
					
					
				}
				
			}
			
		}
		
	}
	
	public void deletenews(ArrayList<NewsModel> news)
	{
		String updateQuery="";
		for(NewsModel anouncement:news)
		{
			System.out.println(anouncement.isSelected());
			if(anouncement.isSelected())
			{
				
					updateQuery = "delete from news";
					updateQuery +=" where newID="+anouncement.getNewID();
					System.out.println(update(updateQuery));
					
					
				
				
			}
			
		}
		
	}

}
