package com.biletcim.entities;

import java.util.Comparator;

import javax.persistence.Column;

import org.springframework.lang.Nullable;

import com.biletcim.helpers.WebUtils;

public class Ticket {
	
	private int 	ticketID;
	private String ticketNumber;
	
	private String ticketDate;
	private String kalkisZamani;
	private String varisZamani;
	
	private String sure;
	
	private String ucakModelName;
	private String ucakModelType;
	
	private String kalkisYeri;
	private String varisYeri;

	private double fiyat;
	
	private String sinif;
	
	
	
	

	private Company company;
	
	
	private String sales_uuid;
	
	
	private String sales_salt;

	

	

	public String getTicketDate() {
		
		
		String dateD=ticketDate.substring(8, 10);
    	String dateM=ticketDate.substring(5, 7);
    	String dateY=ticketDate.substring(0, 4);
    	return dateD+ " "+dateM+" "+dateY;
	}
		public String getTicketDateMMMMTR() {
		WebUtils utils = new WebUtils();
		
		
		String dateD=ticketDate.substring(8, 10);
    	String dateM=utils.convertDateTR(ticketDate.substring(5, 7));
    	String dateY=ticketDate.substring(0, 4);
    	return dateD+ " "+dateM+" "+dateY;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	
	
	public Ticket(int ticketID, String ticketNumber, String ticketDate, String kalkisZamani, String varisZamani,
			String sure, String ucakModelName, String ucakModelType, String kalkisYeri, String varisYeri, double fiyat,
			String sinif, Company company, String sales_uuid, String sales_salt) {
		super();
		this.ticketID = ticketID;
		this.ticketNumber = ticketNumber;
		this.ticketDate = ticketDate;
		this.kalkisZamani = kalkisZamani;
		this.varisZamani = varisZamani;
		this.sure = sure;
		this.ucakModelName = ucakModelName;
		this.ucakModelType = ucakModelType;
		this.kalkisYeri = kalkisYeri;
		this.varisYeri = varisYeri;
		this.fiyat = fiyat;
		this.sinif = sinif;
		this.company = company;
		this.sales_uuid = sales_uuid;
		this.sales_salt = sales_salt;
	}
	public String getSinif() {
		return sinif;
	}
	public void setSinif(String sinif) {
		this.sinif = sinif;
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
	public String getSales_uuid() {
		return sales_uuid;
	}
	public void setSales_uuid(String sales_uuid) {
		this.sales_uuid = sales_uuid;
	}
	public String getSales_salt() {
		return sales_salt;
	}
	public void setSales_salt(String sales_salt) {
		this.sales_salt = sales_salt;
	}

	

	
	 public static Comparator<Ticket> StuRollPrice = new Comparator<Ticket>() {

			public int compare(Ticket s1, Ticket s2) {

			   double rollno1 = s1.getFiyat();
			   double rollno2 = s2.getFiyat();

			   /*For ascending order*/
			   return (int) (rollno1-rollno2);

			   /*For descending order*/
			   //rollno2-rollno1;
		   }};
		   
		   public static Comparator<Ticket> StuRollTime = new Comparator<Ticket>() {

				public int compare(Ticket s1, Ticket s2) {

				   String rollno1 = s1.getKalkisZamani().toLowerCase();
				   String rollno2 = s2.getKalkisZamani().toLowerCase();

				   /*For ascending order*/
				   return rollno1.compareTo(rollno2);
				   

				   /*For descending order*/
				   //rollno2-rollno1;
			   }};
	
	
	
	
	
	
	
	
	
	

}
