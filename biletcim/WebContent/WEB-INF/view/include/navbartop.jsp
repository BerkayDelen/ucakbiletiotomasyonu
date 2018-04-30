<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.biletcim.configs.Config"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <header>
<div class="navigation-bar">
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}">
      <img  class="header-img"   longdesc="${pageContext.request.contextPath}">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     
      
      <ul class="nav navbar-nav navbar-right">
     <%
     String contextPath = request.getContextPath();
    String Cookie_ID = "";
     
     Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			if(c.getName().equals("Login_ID")){
				Cookie_ID = c.getValue();
				System.out.println(c.getName() + "=" + c.getValue());
				break;
			}
			
			}
		if(!Cookie_ID.equals("")){
			String getCookies = "Select count(*) as count from users  Inner JOIN logincookies  ON users.Id = logincookies.loginCookie_User_ID where loginCookie_Key = ?";
			
			try {
				Config.OpenDB(getCookies);
			
				Config.stmt.setString(1,Cookie_ID);
			ResultSet rs =	Config.stmt.executeQuery();
				while(rs.next()){
					int action  = rs.getInt("count");
					try{
						if(action >= 1){
	    			    	 out.println("<li><a href='"+contextPath+"/Logout'><i class='fas fa-times-circle'></i> Çıkış</a></li>");
	    			    	 out.println("<li><a href='/'><i class='fas fa-ticket-alt'></i> Biletlerim</a></li>");
	    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
	    			    	 out.println("<li><a href='"+contextPath+"/plane/check-in/control' ><i class='fas fa-calendar-check'></i> Check-in</a></li>");
	    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
	    			     }else{
	    					 out.println("<li><a href='"+contextPath+"/Login'><i class='fas fa-user'></i> Üye Girişi</a></li>");
	    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
	    			    	 out.println("<li><a href='"+contextPath+"/plane/check-in/control' ><i class='fas fa-calendar-check'></i> Check-in</a></li>");
	    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
	    				}
		    			    		
		    		}
		    		catch (Exception e){
		    			out.println("HATA:"+e.getMessage());
		    		}
	   
				}
				rs.close();
		
				Config.CloseDB();




			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}else if(session.getAttribute("Login_Session") !=null){
			
			String getSession = "Select count(*) as count from users  where User_UniqID = ?";
			
			try {
				
        			//out.println(session.getAttribute("Login_Session"));
				Config.OpenDB(getSession);
			
				Config.stmt.setString(1,session.getAttribute("Login_Session").toString());
			ResultSet rs =	Config.stmt.executeQuery();
				while(rs.next()){
					int action  = rs.getInt("count");
					try{
		    			     if(action >= 1){
		    			    	 out.println("<li><a href='"+contextPath+"/Logout'><i class='fas fa-times-circle'></i> Çıkış</a></li>");
		    			    	 out.println("<li><a href='/'><i class='fas fa-ticket-alt'></i> Biletlerim</a></li>");
		    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
		    			    	 out.println("<li><a href='"+contextPath+"/plane/check-in/control' ><i class='fas fa-calendar-check'></i> Check-in</a></li>");
		    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
		    			     }else{
		    					 out.println("<li><a href='"+contextPath+"/Login'><i class='fas fa-user'></i> Üye Girişi</a></li>");
		    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
		    			    	 out.println("<li><a href='"+contextPath+"/plane/check-in/control' ><i class='fas fa-calendar-check'></i> Check-in</a></li>");
		    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
		    				}
		    			    		
		    		}
		    		catch (Exception e){
		    			out.println("HATA Session in:"+e.getMessage());
		    		}
	   
				}
				rs.close();
		
				Config.CloseDB();




			} catch (SQLException e) {
				
				out.println("HATA Session:"+e.getMessage());
				
			}
			
			/*
			try{
    			if(session.getAttribute("Login") !=null){
        			out.println(session.getAttribute("Login"));
    	    		
    			     if(session.getAttribute("Login")=="true"){
    			    	 out.println("<li><a href='http://localhost:8080/Logout'><i class='fas fa-times-circle'></i> Çıkış</a></li>");
    			    	 out.println("<li><a href='/'><i class='fas fa-ticket-alt'></i> Biletlerim</a></li>");
    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
    			     }else{
    					 out.println("<li><a href='http://localhost:8080/Login'><i class='fas fa-user'></i> Üye Girişi</a></li>");
    			    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
    			    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
    				}
    			    		}else{
    			    			 out.println("<li><a href='http://localhost:8080/Login'><i class='fas fa-user'></i> Üye Girişi</a></li>");
    			    	    	 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
    			    	    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
    			    		}
    		}
    		catch (Exception e){
    			out.println("HATA:"+e.getMessage());
    		}
			*/
			
		}else{
			
			
			 out.println("<li><a href='"+contextPath+"/Login'><i class='fas fa-user'></i> Üye Girişi</a></li>");
			 out.println("<li><a href='#' ><i class='fas fa-hourglass'></i> Bilet Sorgula</a></li>");
	    	 out.println("<li><a href='"+contextPath+"/plane/check-in/control' ><i class='fas fa-calendar-check'></i> Check-in</a></li>");
	    			 out.println("<li><a href='#' ><i class='fas fa-info-circle'></i> Yardım</a></li>");
		}
     
     
     
    
    
     
     //out.println(session.getAttribute("Login").toString()+"\n"+ session.getAttribute("UserName").toString()+"\n"+session.getAttribute("FullName").toString());
    		
    
    
     
    
     %>
        
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	</div>
	</header>