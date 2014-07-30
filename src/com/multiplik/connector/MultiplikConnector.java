package com.multiplik.connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiplikConnector extends Connector {
	

	
	public MultiplikConnector() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException 
	{
		super();
		
	}
	
	public  void addNewList (String schoolName,int schoolGrade, String[] subjects)
	{
		try {
			PreparedStatement statement = con.prepareStatement("SELECT id_school FROM schools WHERE school_name = ?");
			statement.setString(1, schoolName);
			ResultSet resultSet ;
			resultSet = statement.executeQuery();
			
			if (resultSet.next())
			{
				
				String schoolID = resultSet.getString(1);
				System.out.println("[INFO] schoolID="+schoolID);
				ejecutar("INSERT INTO list (grade,scholar_year,id_school) VALUES("+schoolGrade+","+"2014"+","+schoolID+")");
				System.out.println("[INFO] lista agregada con exito");
				System.out.println("[INFO] "+"SELECT id_list FROM list WHERE "+"id_school='"+schoolID+"'");
				resultSet = null;
				resultSet = consulta("SELECT id_list FROM list WHERE "+"id_school='"+schoolID+"' AND grade = '"+schoolGrade+"'");
				if (resultSet.next())
				{
					String listID = resultSet.getString(1);
					for (String s : subjects)
					{	
						System.out.println("[INFO] INSERT INTO subject (subject_name,list_id) VALUES ("+s+","+listID+"); ");
						statement = null;
						statement = con.prepareStatement("INSERT INTO subject (subject_name,list_id) VALUES ( ? , ? )");
						statement.setString(1, s);
						statement.setInt(2, Integer.parseInt(listID));
						statement.execute();
					
						
				
					/*	mysql = "INSERT INTO subjects_peer_list (subject_id,list_id) VALUES ('"+s+ ","+listID+" ')";
						con.ejecutar(mysql);*/
					}
					
				}
				
			}
			//String schoolID = con.consulta(mysql).getString(0);
			//mysql = "INSERT INTO list(grade,school_year)";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
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
		
	}*/
	
	public  List<String> getLists()  
	{
		PreparedStatement statement;
	//	String[][] tableList = new String[][];
		List<String> tableList = new ArrayList<String>();
		ResultSet result;
		try {
			statement = con.prepareStatement("SELECT * FROM list;");
			result = statement.executeQuery();
			//result = con.consulta("SELECT * FROM list;");
	
			//System.out.println("[INFO] "+result);
			
		//	System.out.print("[INFO] Numero de tablas: "+result.getMetaData());
			while(result.next())
			{ 
				System.out.println(result.getString(3));
				tableList.add(result.getString(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return tableList;
			}
	
	
	public  void addNewSchool (String schoolName)
	{
		
		//String mysql = "INSERT INTO schools (school_name) VALUES('"+schoolName + "');";
		try {
			PreparedStatement statement = con.prepareStatement("INSERT INTO schools (school_name) VALUES (?);");
			statement.setString(1, schoolName);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//con.ejecutar(mysql);
			
	}
	
	public  List<String> getSubjectList(int listID)
	{
		List <String> subjectsList = new ArrayList<String>();
		ResultSet result;
		PreparedStatement statement;
		
		try {
			statement = con.prepareStatement("SELECT subject_name FROM subject WHERE list_id = ?");
			statement.setInt(1, listID);
			//result = con.consulta("SELECT * FROM `"+tableName+"`;");
			result = statement.executeQuery();
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
	
	public  List<String> getSchools(){
		List<String> schoolList = new ArrayList<String>();
		ResultSet result;
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM schools");
			result =statement.executeQuery();
			//result = con.consulta("SELECT * FROM schools;");
			
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
	
	public  void getListOfList (HashMap<Integer, String> listMap)
	{
		//List<String> listaDeListas = new ArrayList<String>();
		PreparedStatement statement;
		listMap.clear();
		ResultSet result;
		try {
			 statement  = con.prepareStatement("SELECT school_name, grade, id_list FROM schools,list WHERE list.id_school = schools.id_school; ");
		     result = statement.executeQuery();
		     while (result.next())
		     {
		    	
		    	// listaDeListas.add();
		    	 listMap.put(result.getInt(3), result.getString(1) + " " + result.getString(2));
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	return listaDeListas;
	}
	
	public  void deleteList(int id)
	{
		
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("DELETE FROM list WHERE id_list = ?");
			statement.setInt(1, id);
			statement.execute();
			statement = con.prepareStatement("DELETE FROM subject WHERE list_id = ?");
			statement.setInt(1, id);
			statement.execute();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
	

	
}
