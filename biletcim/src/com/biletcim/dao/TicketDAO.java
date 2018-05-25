package com.biletcim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Plane;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Data_Seat;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Ticket;


public interface TicketDAO {
	
	public void AddBuyTicket(BuyTicket buyTicket);

	public void AddTicket(Data_Ticket data_Ticket);

	public void AddTicketSaveDate(Data_TicketsSaveDate data_TicketsSaveDate);

	public void addPlane(Data_Plane data_Plane);

	public Data_Plane getPlaneControl(Data_Plane data_Plane);

	public Ticket getLastTicketByTicketNumber(String ticketNumber);

	public Data_Sale getTicketByNumberANDFullName(String ticketNumber, String name, String surname);
	
	public List<Data_Seat> getTicketSeats(String ticketNumber);
	
	public Boolean TicketSeatSave(String TicketUniqNumber, String Seat);
	
	public Data_Seat getTicketByTicketKey(String TicketKey);

	public Boolean TicketControlisAlreadySelectSeat(String TicketUniqNumber);

	public List<Data_Seat> getTicketByUser(String UserId);

	

}
