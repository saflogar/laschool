package com.multiplik.connector;
import java.sql.*;

public class Connector {
    private Connection con;
    private Statement sentSQL;
    private ResultSet rst;


    public Connector() throws ClassNotFoundException,SQLException,InstantiationException,IllegalAccessException{
        //cargar el controlador jdbc
        String controlador="com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        conectar(); //conectar con la fuente de datos
    }

    private void conectar() throws SQLException{
    	//datos necesarios para la conexion
    	String URL_bd="jdbc:mysql://localhost/multiplik";
    	String usuario="multiplik";
    	String contrasena="multiplik";	
    	//conexion con la bd
    	con = DriverManager.getConnection(URL_bd,usuario,contrasena);
    	// se crea una Statement para asi poder usar sentencias sql
    	sentSQL=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	
    }
    
    public void close() throws SQLException
    {
    	con.close();
    }
    
/*
public ResultSet ConectarBD(String usuario, String pass) throws SQLException{

rst=sentSQL.executeQuery("select * from usuario where usuario='aeroslizth' AND password='123';");
return rst;
}
*/

  
    // metodo para ejecutar sentencias sql
     public int ejecutar(String sql) throws SQLException
{
          //executeUpdate nos sirve para hacer UPDATE, INSERT y ese tipo de sentencias que modifican la base de datos
         // no se necesita devolver algo
    	 return sentSQL.executeUpdate(sql);
}
     
     //metodo para ejecutar consultas de sentencias sql en la base de datos
     public ResultSet consulta(String sql) throws SQLException{
         
         //executeQuery nos sirve solamente para hacer consultas de la base de datos, solo acepta sentencias como SELECT
         // se necesita forzosamente devolver algo, guardar en una variable el resultado de la consulta
        rst=sentSQL.executeQuery(sql);
        
       return rst;
    }
     
}