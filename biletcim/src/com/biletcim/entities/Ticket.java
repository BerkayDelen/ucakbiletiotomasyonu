package com.biletcim.entities;

public class Ticket {
	
	private int 	ticketID;
	private String ticketNumber;
	
	private String kalkisZamani;
	private String varisZamani;
	
	private String sure;
	
	private String ucakModelName;
	private String ucakModelType;

	private double fiyat;
	
	

	public Ticket(int ticketID, String ticketNumber, String kalkisZamani, String karisZamani, String sure,
			String ucakModelName, String ucakModelType, double fiyat) {
		super();
		this.ticketID = ticketID;
		this.ticketNumber = ticketNumber;
		this.kalkisZamani = kalkisZamani;
		this.varisZamani = karisZamani;
		this.sure = sure;
		this.ucakModelName = ucakModelName;
		this.ucakModelType = ucakModelType;
		this.fiyat = fiyat;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getKalkisZamani() {
		return kalkisZamani;
	}

	public void setKalkisZamani(String kalkisZamani) {
		this.kalkisZamani = kalkisZamani;
	}

	
	public String getVarisZamani() {
		return varisZamani;
	}

	public void setVarisZamani(String varisZamani) {
		this.varisZamani = varisZamani;
	}

	

	public String getSure() {
		return sure;
	}

	public void setSure(String sure) {
		this.sure = sure;
	}

	public String getUcakModelName() {
		return ucakModelName;
	}

	public void setUcakModelName(String ucakModelName) {
		this.ucakModelName = ucakModelName;
	}

	public String getUcakModelType() {
		return ucakModelType;
	}

	public void setUcakModelType(String ucakModelType) {
		this.ucakModelType = ucakModelType;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	
	
	
	
	
	
	
	

}
