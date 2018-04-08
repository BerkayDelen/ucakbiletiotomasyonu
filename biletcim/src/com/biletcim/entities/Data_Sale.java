package com.biletcim.entities;

public class Data_Sale {
	
	private Ticket ticket;
	
	private Sale_User user;
	
	public Data_Sale(Ticket ticket, Sale_User user) {
		super();
		this.ticket = ticket;
		this.user = user;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Sale_User getUser() {
		return user;
	}

	public void setUser(Sale_User user) {
		this.user = user;
	}

	

	
	
}
