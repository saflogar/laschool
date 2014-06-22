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
	
	public void createNewSubjectTable (String tableName, List<String> subjects)
	{
		try {
			String mysql ="CREATE TABLE `"+tableName+"` ( subject VARCHAR(20) )";
			System.out.print("[INFO] creating table: " + mysql);
			con.ejecutar(mysql);
			for (int i = 0; i < subjects.size();i++)
			{
				mysql = "INSERT INTO `"+tableName + "`(subject) VALUES ('"+subjects.get(i)+ "')";
				con.ejecutar(mysql);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getTables()  
	{
		List<String> tableList = new ArrayList<String>();
		ResultSet result;
		try {
			result = con.consulta("SHOW TABLES;");
	
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
	
}
