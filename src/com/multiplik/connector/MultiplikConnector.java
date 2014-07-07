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
	
	public void addNewList (String schoolName,int schoolGrade, String[] subjects)
	{
		try {
			String mysql;
			mysql = "SELECT id_school FROM schools WHERE school_name='"+schoolName+"';";
			System.out.println("[INFO] Executin mysql query: "+mysql);
			ResultSet resultSet = con.consulta(mysql);
			if (resultSet.next())
			{
				
				String schoolID = resultSet.getString(1);
				System.out.println("[INFO] schoolID="+schoolID);
				con.ejecutar("INSERT INTO list (grade,scholar_year,id_school) VALUES("+schoolGrade+","+"2014"+","+schoolID+")");
				System.out.println("[INFO] lista agregada con exito");
				System.out.println("[INFO] "+"SELECT id_list FROM list WHERE "+"id_school='"+schoolID+"'");
				resultSet = null;
				resultSet = con.consulta("SELECT id_list FROM list WHERE "+"id_school='"+schoolID+"' AND grade = '"+schoolGrade+"'");
				if (resultSet.next())
				{
					String listID = resultSet.getString(1);
					for (String s : subjects)
					{	
						System.out.println("[INFO] INSERT INTO subject (subject_name,list_id) VALUES ("+s+","+listID+"); ");
						mysql ="INSERT INTO subject (subject_name,list_id) VALUES ('"+s+"',"+listID+");";
						con.ejecutar(mysql);
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
				System.out.println(result.getString(3));
				tableList.add(result.getString(3));
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
