package com.biletcim.services;

import org.springframework.stereotype.Service;

import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Plane;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Ticket;

@Service
public interface TicketService {
	
	public void AddTicket(Data_Ticket data_Ticket);

	public void AddTicketSaveDate(Data_TicketsSaveDate data_TicketsSaveDate);

	public void addPlane(Data_Plane data_Plane);
	
	public Data_Plane getPlaneControl(Data_Plane data_Plane);

	public Ticket getLastTicketByTicketNumber(String TicketNumber);
	
	public void AddBuyTicket(BuyTicket buyTicket);
	
	
}
