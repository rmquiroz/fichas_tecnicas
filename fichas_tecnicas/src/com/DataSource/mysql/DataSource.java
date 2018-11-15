package com.DataSource.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
	private static DataSource ds=null;
	private static final String JDBC_DRIVER = "org.postgresql.Driver";  
	private static final String DB_URL = "jdbc:postgresql://10.1.250.20:5932/openbravo";
	private static final String USER = "postgres";
	private static final String PASS = "s3st2m1s4e";
	private DataSource(){
		
	}
    public static DataSource getInstace(){
    	if(ds==null){
    		ds=new DataSource();
    	}
    	return ds;
    }
    public static Connection getConnection(){
    	Connection conn = null;
    	   try{
    	      Class.forName(JDBC_DRIVER);
    	      System.out.println("Connecting to database...");
    	      conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    	      System.out.println("CONECTADO");
    	   }catch(Exception e){
    		   try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    		   e.printStackTrace();
    	   }
    return conn;
    }
}
