package com.multiplik.connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MultiplikConnector {
	
	Connector con;
	
	public MultiplikConnector()
	{
		try {
			con = new Connector();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNewSubject (String listName, List<String> subjects)
	{
		try {
			String mysql;
			for (int i = 0; i < subjects.size();i++)
			{
				mysql = "INSERT INTO subjects_peer_list (subject) VALUES ('"+subjects.get(i)+ "')";
				con.ejecutar(mysql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteList (String tableName)
	{
		String mysql = "DROP TABLE `" + tableName + "`";
		System.out.println("[INFO] table: '"+tableName+"' deleted with success");
		try {
			con.ejecutar(mysql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<String> getLists()  
	{
		List<String> tableList = new ArrayList<String>();
		ResultSet result;
		try {
			result = con.consulta("SELECT * FROM list;");
	
			System.out.println("[INFO] "+result);

		//	System.out.print("[INFO] Numero de tablas: "+result.getMetaData());
			while(result.next())
			{ 
				System.out.println(result.getString(1));
				tableList.add(result.getString(1));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return tableList;
			}
	
	public void addNewSchool (String schoolName)
	{
		String mysql = "INSERT INTO schools (school_name) VALUES('"+schoolName + "');";
		try {
			con.ejecutar(mysql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//con.ejecutar(mysql);
			
	}
	
	public List<String> getSubjectList(String tableName)
	{
		List <String> subjectsList = new ArrayList<String>();
		ResultSet result;
		
		try {
			result = con.consulta("SELECT * FROM `"+tableName+"`;");
			
			while (result.next())
			{
				subjectsList.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subjectsList;
	}
	
	public List<String> getSchools(){
		List<String> schoolList = new ArrayList<String>();
		ResultSet result;
		
		try {
			result = con.consulta("SELECT * FROM schools;");
			
			while (result.next())
			{
				schoolList.add(result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return schoolList;
	}
	
}
