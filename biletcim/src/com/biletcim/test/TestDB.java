package com.biletcim.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TestDB")
public class TestDB extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException	 {
		
		String user ="root";
		String pass ="root";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/dbbiletcim?useSSL=false";
		
		String driver = "com.mysql.jdbc.Driver";
		try {
		PrintWriter out =response.getWriter();
		out.println("Veritabaný Baðlantýsý: "+jdbcUrl);
		
			Class.forName(driver);
			
			
				Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
				
				out.println("Baðlantý Baþarýlý.");
				
				myConn.close();
			
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
