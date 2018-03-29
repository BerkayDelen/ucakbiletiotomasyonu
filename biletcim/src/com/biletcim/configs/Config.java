package com.biletcim.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Config {
	//Api Keys
	public static String apiKeyPublic = "l7xxc7cf29ae22e74bada8787d9f8240513e";
	public static String apiKeySecret = "eb5d3e6148284a7b91c646afe8c433ae";
	// JDBC driver name and database URL
	 /* public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  public static final String DB_URL = "jdbc:mysql://localhost/dbbiletcim";

	   //  Database credentials
	  public  static final String USER = "root";
	  public static final String PASS = "root";*/
	
	 public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  public static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11229413";

	   //  Database credentials
	  public  static final String USER = "sql11229413";
	  public static final String PASS = "1Zyy3lhi8A";
	  
	  public static Connection conn = null;
	  public static PreparedStatement stmt = null;
	   
	  public static void OpenDB(String sql) {
		  
		 
		   try{
		//STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.prepareStatement(sql);

	      

	      
	     
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   
	  }
	  public static void CloseDB() {
		  try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		      System.out.println("Goodbye!");
	  }

}
