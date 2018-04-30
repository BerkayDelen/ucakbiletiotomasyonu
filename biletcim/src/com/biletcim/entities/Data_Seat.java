package com.biletcim.entities;

public class Data_Seat {
	
	private Ticket ticket;
	
	private Sale_User user;
	
	private String seat_Number;

	
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

	public String getSeat_Number() {
		return seat_Number;
	}

	public void setSeat_Number(String seat_Number) {
		this.seat_Number = seat_Number;
	}
	

	

}
