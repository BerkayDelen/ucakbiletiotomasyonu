package com.biletcim.dao;

import org.springframework.stereotype.Repository;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Plane;
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

}
