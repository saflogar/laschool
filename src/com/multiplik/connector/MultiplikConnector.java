package com.multiplik.connector;

import java.sql.SQLException;

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
	
	public void createNewSubjectTable (String tableName)
	{
		try {
			String mysql ="CREATE TABLE "+tableName+" ( subject VARCHAR(20) );";
			System.out.print("[INFO] creating table: " + mysql);
			con.ejecutar(mysql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
