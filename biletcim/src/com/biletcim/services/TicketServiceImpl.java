package com.biletcim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biletcim.dao.TicketDAO;
import com.biletcim.entities.BuyTicket;
import com.biletcim.entities.Data_Plane;
import com.biletcim.entities.Data_Sale;
import com.biletcim.entities.Data_Seat;
import com.biletcim.entities.Data_Ticket;
import com.biletcim.entities.Data_TicketsSaveDate;
import com.biletcim.entities.Ticket;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDAO ticketDAO;

	@Override
	@Transactional
	public void AddBuyTicket(BuyTicket buyTicket) {
		ticketDAO.AddBuyTicket(buyTicket);

	}

	


	@Override
	@Transactional
	public void AddTicket(Data_Ticket data_Ticket) {
		ticketDAO.AddTicket(data_Ticket);
		
	}

	@Override
	@Transactional
	public void AddTicketSaveDate(Data_TicketsSaveDate data_TicketsSaveDate) {
		ticketDAO.AddTicketSaveDate(data_TicketsSaveDate);
		
	}

	@Override
	@Transactional
	public void addPlane(Data_Plane data_Plane) {
		
		ticketDAO.addPlane(data_Plane);

		
	}
	

	@Override
	@Transactional
	public Data_Plane getPlaneControl(Data_Plane data_Plane) {
		
		return ticketDAO.getPlaneControl(data_Plane);
		 
	}
	
	@Override
	@Transactional
	public Ticket getLastTicketByTicketNumber(String TicketNumber,String _Class) {
		
		return ticketDAO.getLastTicketByTicketNumber(TicketNumber,_Class);
	}




	@Override
	@Transactional
	public Data_Sale getTicketByNumberANDFullName(String ticketNumber, String name, String surname) {
		return ticketDAO.getTicketByNumberANDFullName(ticketNumber,name,surname);
		
	}

	@Override
	public List<Data_Seat> getTicketSeats(String ticketNumber) {
		return ticketDAO.getTicketSeats(ticketNumber);
	}




	@Override
	public Boolean TicketSeatSave(String TicketUniqNumber, String Seat) {
		return ticketDAO.TicketSeatSave(TicketUniqNumber, Seat);
	}




	@Override
	public Data_Seat getTicketByTicketKey(String TicketKey) {
		return ticketDAO.getTicketByTicketKey(TicketKey);
	}




	@Override
	public Boolean TicketControlisAlreadySelectSeat(String TicketUniqNumber) {
		return ticketDAO.TicketControlisAlreadySelectSeat(TicketUniqNumber);
	}




	@Override
	public List<Data_Seat> getTicketByUser(String UserId) {
		return ticketDAO.getTicketByUser(UserId);
	}




	@Override
	public List<Ticket> getMostPopularTicket() {
		return ticketDAO.getMostPopularTicket();
	}

}
