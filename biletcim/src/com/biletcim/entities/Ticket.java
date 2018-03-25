package com.biletcim.entities;

import org.springframework.lang.Nullable;

public class Ticket {
	
	private int 	ticketID;
	private String ticketNumber;
	
	private String kalkisZamani;
	private String varisZamani;
	
	private String sure;
	
	private String ucakModelName;
	private String ucakModelType;
	
	private String kalkisYeri;
	private String varisYeri;

	private double fiyat;
	
	
	
	
	private Company company;
	
	


	

	

	public Ticket(
			int ticketID,
			String ticketNumber,
			String kalkisZamani,
			String varisZamani,
			String sure,
			String ucakModelName,
			String ucakModelType,
			String kalkisYeri,
			String varisYeri,
			double fiyat,
			Company company) {
		super();
		this.ticketID = ticketID;
		this.ticketNumber = ticketNumber;
		this.kalkisZamani = kalkisZamani;
		this.varisZamani = varisZamani;
		this.sure = sure;
		this.ucakModelName = ucakModelName;
		this.ucakModelType = ucakModelType;
		this.kalkisYeri = kalkisYeri;
		this.varisYeri = varisYeri;
		this.fiyat = fiyat;
		this.company = company;
	}

	public String getKalkisYeri() {
		return kalkisYeri;
	}

	public void setKalkisYeri(String kalkisYeri) {
		this.kalkisYeri = kalkisYeri;
	}

	public String getVarisYeri() {
		return varisYeri;
	}

	public void setVarisYeri(String varisYeri) {
		this.varisYeri = varisYeri;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	

}
