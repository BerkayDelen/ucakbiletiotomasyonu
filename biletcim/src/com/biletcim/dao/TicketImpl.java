package com.biletcim.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biletcim.configs.Config;
import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Company;
import com.biletcim.entities.Data_Plane;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Sale_User;
import com.biletcim.entities.Ticket;
import com.biletcim.entities.User;

@Repository
public class TicketImpl implements TicketDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void AddBuyTicket(BuyTicket buyTicket) {
		Session session = sessionFactory.getCurrentSession();
		session.save(buyTicket);
		
	}

	@Override
	public void AddTicket(Data_Ticket data_Ticket) {
		try {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(data_Ticket);
		}catch (HibernateException ex) {

	        Throwable cause = ex.getCause();
	        if (cause instanceof SQLException) {
	            System.out.println("SQL HATA: "+cause.getMessage());
	        }
	 }
	}

	@Override
	public void AddTicketSaveDate(Data_TicketsSaveDate data_TicketsSaveDate) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(data_TicketsSaveDate);
			}catch (HibernateException ex) {

		        Throwable cause = ex.getCause();
		        if (cause instanceof SQLException) {
		            System.out.println("SQL Error in data_TicketsSaveDate: "+cause.getMessage());
		        }
		 }
		
	}

	@Override
	public void addPlane(Data_Plane data_Plane) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(data_Plane);
			
			}catch (HibernateException ex) {

		        Throwable cause = ex.getCause();
		        if (cause instanceof SQLException) {
		            System.out.println("SQL Error in data_TicketsSaveDate: "+cause.getMessage());
		        }
		 }
		
	}
	
	@Override
	public Data_Plane getPlaneControl(Data_Plane data_Plane) {
		 Data_Plane data  = null;
		 
		
			Session session = sessionFactory.getCurrentSession();
			//session.saveOrUpdate(data_Plane);
			
			Query<Data_Plane> query = session.createQuery("from Planes where Plane_Name = :Plane_Name and Plane_Model= :Plane_Model",Data_Plane.class);
			//where Planes.Plane_Name = :Plane_Name and  Planes.Plane_Model = :Plane_Model 
			       query.setParameter("Plane_Name", data_Plane.getPlane_Name());
			       query.setParameter("Plane_Model", data_Plane.getPlane_Model());
			        
			
			        // You can replace the above to commands with this one
			
			        // Query query = session.createQuery("from Student where studentId = 1 ");
			
			        List<Data_Plane> list =  query.getResultList();
			        System.out.println("SÝZE:::"+list.size());
			 if(list.size()!=0) {
				  data = list.get(0);
			 }else {
				 data = data_Plane;
				 
			 }
			
			      

			        
			
		return data;
		
	}

	@Override
	public Ticket getLastTicketByTicketNumber(String ticketNumber) {
		// TODO Auto-generated method stub
		Ticket ticket = null;
		
		String getSession = "SELECT company.*,tickets.* FROM `tickets` INNER JOIN company ON company.companyId = tickets.companyID where ticketNumber = ? order by save_date DESC limit 1";
		
		try {
			
    			
			Config.OpenDB(getSession);
		
			Config.stmt.setString(1,ticketNumber);
		ResultSet rs =	Config.stmt.executeQuery();
			while(rs.next()){
				int ticketID  = rs.getInt("ticketID");
				//String ticketNumber  = rs.getString("ticketNumber");
				String ticketDate  = rs.getString("ticketDate");
				String kalkisZamani  = rs.getString("kalkisZamani");
				String varisZamani  = rs.getString("varisZamani");
				
				String sure  = rs.getString("sure");
				String Plane_Name  = rs.getString("Plane_Name");
				String Plane_Model  = rs.getString("Plane_Model");
				String kalkisYeri  = rs.getString("kalkisYeri");
				String varisYeri  = rs.getString("varisYeri");
				double fiyat  = rs.getDouble("fiyat");
				int companyID  = rs.getInt("companyID");
				int save_date  = rs.getInt("save_date");
				Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"), rs.getString("companyImg"));
				
				 ticket = new Ticket(
						ticketID,
						ticketNumber,
						ticketDate,
						kalkisZamani,
						varisZamani,
						sure,
						Plane_Name,
						Plane_Model,
						kalkisYeri,
						varisYeri,
						fiyat,
						company);
   
			}
			rs.close();
	
			Config.CloseDB();




		} catch (SQLException e) {
			
			System.out.println("HATA  Session Create Read Data in:"+e.getMessage());
			
		}
		
		
		
		return ticket;
	}

	
	@Override
	public Data_Sale getTicketByNumberANDFullName(String ticketNumber, String name, String surname) {
		
		Sale_User user = null;
			Ticket ticket = null;
			
			
		
		String getSession = "SELECT company.*,tickets.*,sales.* FROM `sales` " + 
				"INNER JOIN tickets ON tickets.ticketID = sales.sales_ticket_id " + 
				"INNER JOIN company ON company.companyId = tickets.companyID"+
				" where tickets.ticketNumber = ? and "+
				"sales.sales_user_Name = ? and "+
				"sales.sales_user_Surname = ? limit 1";
		
		try {
			
    			System.out.println(getSession);
			Config.OpenDB(getSession);
		
			Config.stmt.setString(1,ticketNumber);
			Config.stmt.setString(2,name);
			Config.stmt.setString(3,surname);
		ResultSet rs =	Config.stmt.executeQuery();
			while(rs.next()){
				System.out.print("Read:");
				int ticketID  = rs.getInt("ticketID");
				//String ticketNumber  = rs.getString("ticketNumber");
				String ticketDate  = rs.getString("ticketDate");
				String kalkisZamani  = rs.getString("kalkisZamani");
				String varisZamani  = rs.getString("varisZamani");
				
				String sure  = rs.getString("sure");
				String Plane_Name  = rs.getString("Plane_Name");
				String Plane_Model  = rs.getString("Plane_Model");
				String kalkisYeri  = rs.getString("kalkisYeri");
				String varisYeri  = rs.getString("varisYeri");
				double fiyat  = rs.getDouble("fiyat");
				int companyID  = rs.getInt("companyID");
				int save_date  = rs.getInt("save_date");
				Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"), rs.getString("companyImg"));
				
				 ticket = new Ticket(
						ticketID,
						ticketNumber,
						ticketDate,
						kalkisZamani,
						varisZamani,
						sure,
						Plane_Name,
						Plane_Model,
						kalkisYeri,
						varisYeri,
						fiyat,
						company);
				 
				 Boolean sales_user_isLogin  = false; //rs.getBoolean("sales_user_isLogin");
				 int sales_user_id  = 0;//rs.getInt("sales_user_id");
				 
				 
				 String sales_user_Name  = rs.getString("sales_user_Name");
				 String sales_user_Surname  = rs.getString("sales_user_Surname");
				 String sales_user_TC  = rs.getString("sales_user_TC");
				 String sales_user_Email  = rs.getString("sales_user_Email");
				 Date sales_user_Birthday  = rs.getDate("sales_user_Birthday");
				 
				
				 Boolean sales_user_gender  = rs.getBoolean("sales_user_gender");
				 user = new Sale_User(sales_user_isLogin, sales_user_id, sales_user_Name, sales_user_Surname, sales_user_TC, sales_user_Email, sales_user_gender);
				 
				 System.out.println("Name: "+sales_user_Name);
				 System.out.println("Surname: "+sales_user_Surname);
				 System.out.println("Email: "+sales_user_Email);
				 System.out.println("Number : "+ticket.getTicketNumber());
				 System.out.println("Number : "+ticket.getTicketNumber());
				 
			}
			rs.close();
	
			Config.CloseDB();



			
			
		} catch (Exception e) {
			
			System.out.println("HATA : getTicketByNumberANDFullName :  Read Data in:"+e.getMessage());
			
		}
		
		Data_Sale data_Sale = new Data_Sale(ticket, user);
		
		return data_Sale;
	}
	
	

	
	
	

}
