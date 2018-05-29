package com.biletcim.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.biletcim.entities.Data_Seat;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Sale_User;
import com.biletcim.entities.Seats;
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
		} catch (HibernateException ex) {

			Throwable cause = ex.getCause();
			if (cause instanceof SQLException) {
				System.out.println("SQL HATA: " + cause.getMessage());
			}
		}
	}

	@Override
	public void AddTicketSaveDate(Data_TicketsSaveDate data_TicketsSaveDate) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(data_TicketsSaveDate);
		} catch (HibernateException ex) {

			Throwable cause = ex.getCause();
			if (cause instanceof SQLException) {
				System.out.println("SQL Error in data_TicketsSaveDate: " + cause.getMessage());
			}
		}

	}

	@Override
	public void addPlane(Data_Plane data_Plane) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(data_Plane);

		} catch (HibernateException ex) {

			Throwable cause = ex.getCause();
			if (cause instanceof SQLException) {
				System.out.println("SQL Error in data_TicketsSaveDate: " + cause.getMessage());
			}
		}

	}

	@Override
	public Data_Plane getPlaneControl(Data_Plane data_Plane) {
		Data_Plane data = null;

		Session session = sessionFactory.getCurrentSession();
		// session.saveOrUpdate(data_Plane);

		Query<Data_Plane> query = session.createQuery(
				"from Planes where Plane_Name = :Plane_Name and Plane_Model= :Plane_Model", Data_Plane.class);
		// where Planes.Plane_Name = :Plane_Name and Planes.Plane_Model = :Plane_Model
		query.setParameter("Plane_Name", data_Plane.getPlane_Name());
		query.setParameter("Plane_Model", data_Plane.getPlane_Model());

		// You can replace the above to commands with this one

		// Query query = session.createQuery("from Student where studentId = 1 ");

		List<Data_Plane> list = query.getResultList();
		System.out.println("SÝZE:::" + list.size());
		if (list.size() != 0) {
			data = list.get(0);
		} else {
			data = data_Plane;

		}

		return data;

	}

	@Override
	public Ticket getLastTicketByTicketNumber(String ticketNumber,String _Class) {
		// TODO Auto-generated method stub
		Ticket ticket = null;

		String getSession = "SELECT company.*,tickets.* FROM `tickets` INNER JOIN company ON company.companyId = tickets.companyID where ticketNumber = ? and sinif= ? order by save_date DESC limit 1";

		try {

			Config.OpenDB(getSession);

			Config.stmt.setString(1, ticketNumber);
			Config.stmt.setString(2, _Class);
			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) {
				int ticketID = rs.getInt("ticketID");
				// String ticketNumber = rs.getString("ticketNumber");
				String ticketDate = rs.getString("ticketDate");
				String kalkisZamani = rs.getString("kalkisZamani");
				String varisZamani = rs.getString("varisZamani");

				String sure = rs.getString("sure");
				String Plane_Name = rs.getString("Plane_Name");
				String Plane_Model = rs.getString("Plane_Model");
				String kalkisYeri = rs.getString("kalkisYeri");
				String varisYeri = rs.getString("varisYeri");
				double fiyat = rs.getDouble("fiyat");
				String sinif = rs.getString("sinif");
				int companyID = rs.getInt("companyID");
				int save_date = rs.getInt("save_date");
				Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"),
						rs.getString("companyImg"));

				ticket = new Ticket(ticketID, ticketNumber, ticketDate, kalkisZamani, varisZamani, sure, Plane_Name,
						Plane_Model, kalkisYeri, varisYeri, fiyat, sinif, company, "", "");

			}
			rs.close();

			Config.CloseDB();

		} catch (SQLException e) {

			System.out.println("HATA  Session Create Read Data in:" + e.getMessage());

		}

		return ticket;
	}

	@Override
	public Data_Sale getTicketByNumberANDFullName(String ticketNumber, String name, String surname) {

		Sale_User user = null;
		Ticket ticket = null;

		String getSession = "SELECT company.*,tickets.*,sales.* FROM `sales` "
				+ "INNER JOIN tickets ON tickets.ticketID = sales.sales_ticket_id "
				+ "INNER JOIN company ON company.companyId = tickets.companyID" + " where sales.sales_salt = ? and "
				+ "sales.sales_user_Name = ? and " + "sales.sales_user_Surname = ? limit 1";
		//
		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, ticketNumber);
			Config.stmt.setString(2, name);
			Config.stmt.setString(3, surname);
			ResultSet rs = Config.stmt.executeQuery();
			int rowcount = 0;
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst();
			}
			if (rowcount == 0) {
				System.err.println("COunt SELECT TÝCKET ->" + rowcount);
				Data_Sale data_Sale = new Data_Sale(ticket, user);

				return data_Sale;
			}

			while (rs.next()) {
				System.out.print("Read:");
				int ticketID = rs.getInt("ticketID");
				// String ticketNumber = rs.getString("ticketNumber");
				String ticketDate = rs.getString("ticketDate");
				String kalkisZamani = rs.getString("kalkisZamani");
				String varisZamani = rs.getString("varisZamani");

				String sure = rs.getString("sure");
				String Plane_Name = rs.getString("Plane_Name");
				String Plane_Model = rs.getString("Plane_Model");
				String kalkisYeri = rs.getString("kalkisYeri");
				String varisYeri = rs.getString("varisYeri");
				double fiyat = rs.getDouble("fiyat");
				String sinif = rs.getString("sinif");
				int companyID = rs.getInt("companyID");
				int save_date = rs.getInt("save_date");
				Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"),
						rs.getString("companyImg"));

				String sales_uuid = rs.getString("sales_uuid");
				String sales_salt = rs.getString("sales_salt");

				ticket = new Ticket(ticketID, ticketNumber, ticketDate, kalkisZamani, varisZamani, sure, Plane_Name,
						Plane_Model, kalkisYeri, varisYeri, fiyat, sinif, company, sales_uuid, sales_salt);

				Boolean sales_user_isLogin = false; // rs.getBoolean("sales_user_isLogin");
				int sales_user_id = 0;// rs.getInt("sales_user_id");

				String sales_user_Name = rs.getString("sales_user_Name");
				String sales_user_Surname = rs.getString("sales_user_Surname");
				String sales_user_TC = rs.getString("sales_user_TC");
				String sales_user_Email = rs.getString("sales_user_Email");
				Date sales_user_Birthday = rs.getDate("sales_user_Birthday");

				Boolean sales_user_gender = rs.getBoolean("sales_user_gender");
				user = new Sale_User(sales_uuid, sales_salt, sales_user_isLogin, sales_user_id, sales_user_Name,
						sales_user_Surname, sales_user_TC, sales_user_Email, sales_user_gender);

				System.out.println("Name: " + sales_user_Name);
				System.out.println("Surname: " + sales_user_Surname);
				System.out.println("Email: " + sales_user_Email);
				System.out.println("Number : " + ticket.getTicketNumber());
				System.out.println("Number : " + ticket.getTicketNumber());

			}
			rs.close();

			Config.CloseDB();

		} catch (Exception e) {

			System.out.println("HATA : getTicketByNumberANDFullName :  Read Data in:" + e.getMessage());

		}

		Data_Sale data_Sale = new Data_Sale(ticket, user);

		return data_Sale;
	}

	@Override
	public List<Data_Seat> getTicketSeats(String ticketNumber) {

		List<Data_Seat> seats = new ArrayList<Data_Seat>();

		String getSession = "SELECT `seats`.* ,`sales`.* , `tickets`.*  FROM  `seats` "
				+ "INNER JOIN `sales` ON seats.sales_id  = sales.sales_id "
				+ "INNER JOIN `tickets` ON sales.sales_ticket_id = tickets.ticketID  " 
				+ "where tickets.ticketNumber =  (SELECT tickets.ticketNumber FROM sales INNER JOIN tickets ON tickets.ticketID = sales.sales_ticket_id where sales.sales_salt = ? ) ";

		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, ticketNumber);

			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) {

				String seat_Number = rs.getString("seat_Number");
				Data_Seat data_Seat = new Data_Seat();
				data_Seat.setSeat_Number(seat_Number);
				seats.add(data_Seat);

			}
			rs.close();

			Config.CloseDB();

		} catch (Exception e) {

			System.out.println("HATA : getTicketSeats :  Read Data in:" + e.getMessage());

		}

		return seats;
	}
	
	@Override
	public Boolean TicketControlisAlreadySelectSeat(String TicketUniqNumber) {
		Boolean status = false;

		String getSession = "SELECT `sales`.`sales_id` FROM sales INNER JOIN seats ON seats.sales_id = sales.sales_id where sales.sales_salt = ?";

		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, TicketUniqNumber);

			ResultSet rs = Config.stmt.executeQuery();
			int sales_id = 0;
			int counter = 0;
			while (rs.next()) {

				sales_id = rs.getInt("sales_id");
				counter++;

			}
			
			if(counter == 0) {
				status = true;
			}
			

			rs.close();

			Config.CloseDB();

		} catch (Exception e) {
			status = false;
			System.out.println("HATA : TicketControlisAlreadySelectSeat :  Read Data in:" + e.getMessage());

		}

		return status;
	}
	
	@Override
	public Boolean TicketSeatSave(String TicketUniqNumber, String Seat) {
		Boolean status = false;

		String getSession = "SELECT `sales`.`sales_id` FROM sales "
				+ "INNER JOIN `tickets` ON sales.sales_ticket_id = tickets.ticketID " + "where sales.sales_uuid = ?";

		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, TicketUniqNumber);

			ResultSet rs = Config.stmt.executeQuery();
			int sales_id = 0;
			int counter = 0;
			while (rs.next()) {

				sales_id = rs.getInt("sales_id");
				counter++;

			}
			String counsession = "SELECT count(*) as countdata FROM seats "
					+ "INNER JOIN `sales` ON sales.sales_id = seats.sales_id" + " where sales.sales_id = ?";

			Config.OpenDB(counsession);

			Config.stmt.setInt(1, sales_id);

			ResultSet rss = Config.stmt.executeQuery();
			int countdata = 0;
			while (rss.next()) {
				countdata = rss.getInt("countdata");
			}
			System.out.println("Count Data : " + countdata);
			System.out.println("Sales_id : " + sales_id);
			if (sales_id != 0 && countdata == 0) {

				Seats seatsave = new Seats();
				seatsave.setSales_id(sales_id);
				seatsave.setSeat_Number(Seat);

				Session session = sessionFactory.getCurrentSession();
				int id = (int) session.save(seatsave);
				if (id != 0) {
					status = true;
				}
			}

			rss.close();

			rs.close();

			Config.CloseDB();

		} catch (Exception e) {
			status = false;
			System.out.println("HATA : TicketSeatSave :  Read Data in:" + e.getMessage());

		}

		return status;
	}

	@Override
	public Data_Seat getTicketByTicketKey(String TicketKey) {

		Sale_User user = null;
		Ticket ticket = null;
		String Seat = "";

		String getSession = "SELECT seats.*, company.*,tickets.*,sales.* FROM `sales` "
				+ "INNER JOIN tickets ON tickets.ticketID = sales.sales_ticket_id "
				+ "INNER JOIN company ON company.companyId = tickets.companyID "
				+ "INNER JOIN seats ON seats.sales_id = sales.sales_id " + "where sales.sales_uuid = ?";

		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, TicketKey);
			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) {
				System.out.print("Read:");
				Seat = rs.getString("seat_Number");
				int ticketID = rs.getInt("ticketID");
				String ticketNumber = rs.getString("ticketNumber");
				// String ticketNumber = rs.getString("ticketNumber");
				String ticketDate = rs.getString("ticketDate");
				String kalkisZamani = rs.getString("kalkisZamani");
				String varisZamani = rs.getString("varisZamani");

				String sure = rs.getString("sure");
				String Plane_Name = rs.getString("Plane_Name");
				String Plane_Model = rs.getString("Plane_Model");
				String kalkisYeri = rs.getString("kalkisYeri");
				String varisYeri = rs.getString("varisYeri");
				double fiyat = rs.getDouble("fiyat");
				String sinif = rs.getString("sinif");
				int companyID = rs.getInt("companyID");
				int save_date = rs.getInt("save_date");
				Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"),
						rs.getString("companyImg"));

				String sales_uuid = rs.getString("sales_uuid");
				String sales_salt = rs.getString("sales_salt");

				ticket = new Ticket(ticketID, ticketNumber, ticketDate, kalkisZamani, varisZamani, sure, Plane_Name,
						Plane_Model, kalkisYeri, varisYeri, fiyat, sinif, company, sales_uuid, sales_salt);

				Boolean sales_user_isLogin = false; // rs.getBoolean("sales_user_isLogin");
				int sales_user_id = 0;// rs.getInt("sales_user_id");

				String sales_user_Name = rs.getString("sales_user_Name");
				String sales_user_Surname = rs.getString("sales_user_Surname");
				String sales_user_TC = rs.getString("sales_user_TC");
				String sales_user_Email = rs.getString("sales_user_Email");
				Date sales_user_Birthday = rs.getDate("sales_user_Birthday");

				Boolean sales_user_gender = rs.getBoolean("sales_user_gender");
				user = new Sale_User(sales_uuid, sales_salt, sales_user_isLogin, sales_user_id, sales_user_Name,
						sales_user_Surname, sales_user_TC, sales_user_Email, sales_user_gender);

				System.out.println("Name: " + sales_user_Name);
				System.out.println("Surname: " + sales_user_Surname);
				System.out.println("Email: " + sales_user_Email);
				System.out.println("Number : " + ticket.getTicketNumber());
				System.out.println("Number : " + ticket.getTicketNumber());
				System.out.println("Seat : " + Seat);

			}
			rs.close();

			Config.CloseDB();

		} catch (Exception e) {

			System.out.println("HATA : getTicketByNumberANDFullName :  Read Data in:" + e.getMessage());

		}

		Data_Seat data_Sale = new Data_Seat();
		data_Sale.setTicket(ticket);
		data_Sale.setUser(user);
		data_Sale.setSeat_Number(Seat);

		return data_Sale;
	}
	
	@Override
	public List<Data_Seat> getTicketByUser(String UserId) {
		
		List<Data_Seat> tickets = new ArrayList<Data_Seat>();
		
		Sale_User user = null;
		Ticket ticket = null;
		String Seat = "";

		String getSession = "SELECT `seats`.* ,`sales`.* , `tickets`.*  FROM  `seats` "+
				"INNER JOIN `sales` ON seats.sales_id  = sales.sales_id "+
				"INNER JOIN `tickets` ON sales.sales_ticket_id = tickets.ticketID  "+
				"where sales.sales_user_isLogin =  1 and sales.sales_user_id = ?";

		try {

			System.out.println(getSession);
			Config.OpenDB(getSession);

			Config.stmt.setString(1, UserId);
			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) {
				System.out.print("Read:");
				Seat = rs.getString("seat_Number");
				int ticketID = rs.getInt("ticketID");
				String ticketNumber = rs.getString("ticketNumber");
				// String ticketNumber = rs.getString("ticketNumber");
				String ticketDate = rs.getString("ticketDate");
				String kalkisZamani = rs.getString("kalkisZamani");
				String varisZamani = rs.getString("varisZamani");

				String sure = rs.getString("sure");
				String Plane_Name = rs.getString("Plane_Name");
				String Plane_Model = rs.getString("Plane_Model");
				String kalkisYeri = rs.getString("kalkisYeri").substring(rs.getString("kalkisYeri").length() - 3);
				String varisYeri = rs.getString("varisYeri").substring(rs.getString("varisYeri").length() - 3);;
				double fiyat = rs.getDouble("fiyat");
				String sinif = rs.getString("sinif");
				int companyID = rs.getInt("companyID");
				int save_date = rs.getInt("save_date");
				/*Company company = new Company(rs.getInt("companyID"), rs.getString("companyName"),
						rs.getString("companyImg"));*/

				String sales_uuid = rs.getString("sales_uuid");
				String sales_salt = rs.getString("sales_salt");

				ticket = new Ticket(ticketID, ticketNumber, ticketDate, kalkisZamani, varisZamani, sure, Plane_Name,
						Plane_Model, kalkisYeri, varisYeri, fiyat, sinif, null, sales_uuid, sales_salt);

				Boolean sales_user_isLogin = false; // rs.getBoolean("sales_user_isLogin");
				int sales_user_id = 0;// rs.getInt("sales_user_id");

				String sales_user_Name = rs.getString("sales_user_Name");
				String sales_user_Surname = rs.getString("sales_user_Surname");
				String sales_user_TC = rs.getString("sales_user_TC");
				String sales_user_Email = rs.getString("sales_user_Email");
				Date sales_user_Birthday = rs.getDate("sales_user_Birthday");

				Boolean sales_user_gender = rs.getBoolean("sales_user_gender");
				user = new Sale_User(sales_uuid, sales_salt, sales_user_isLogin, sales_user_id, sales_user_Name,
						sales_user_Surname, sales_user_TC, sales_user_Email, sales_user_gender);

				System.out.println("Name: " + sales_user_Name);
				System.out.println("Surname: " + sales_user_Surname);
				System.out.println("Email: " + sales_user_Email);
				System.out.println("Number : " + ticket.getTicketNumber());
				System.out.println("Number : " + ticket.getTicketNumber());
				System.out.println("Seat : " + Seat);
				Data_Seat data_Sale = new Data_Seat();
				data_Sale.setTicket(ticket);
				data_Sale.setUser(user);
				data_Sale.setSeat_Number(Seat);
				tickets.add(data_Sale);
			}
			rs.close();

			Config.CloseDB();

		} catch (Exception e) {

			System.out.println("HATA : getTicketByNumberANDFullName :  Read Data in:" + e.getMessage());

		}

		

		return tickets;
	}

	@Override
	public List<Ticket> getMostPopularTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		

		String getSession = "SELECT MIN(tickets.fiyat) AS 'minFiyat',tickets.kalkisYeri,tickets.varisYeri FROM tickets " + 
				"INNER JOIN ticketssavedate ON ticketssavedate.TicketGroup_id = tickets.save_date " + 
				" GROUP BY ticketssavedate.kalkisYeri,ticketssavedate.varisYeri ORDER BY COUNT(*) DESC LIMIT 12";

		try {

			Config.OpenDB(getSession);

			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) {
				Ticket ticket = null;
				int ticketID = -1;
				// String ticketNumber = rs.getString("ticketNumber");
				String ticketDate = "";
				String kalkisZamani = "";
				String varisZamani = "";

				String sure = "";
				String Plane_Name = "";
				String Plane_Model = "";
				String kalkisYeri = rs.getString("kalkisYeri").substring(rs.getString("kalkisYeri").length() - 3);;
				String varisYeri = rs.getString("varisYeri").substring(rs.getString("varisYeri").length() - 3);;
				double fiyat = rs.getDouble("minFiyat");
				String sinif = "";
				int companyID = -1;
				int save_date = -1;
				Company company = new Company(-1, "",
						"");

				ticket = new Ticket(ticketID, "", ticketDate, kalkisZamani, varisZamani, sure, Plane_Name,
						Plane_Model, kalkisYeri, varisYeri, fiyat, sinif, company, "", "");
				tickets.add(ticket);
			}
			rs.close();

			Config.CloseDB();

		} catch (SQLException e) {

			System.out.println("HATA  getMostPopularTicket in:" + e.getMessage());

		}

		return tickets;
	}

}
