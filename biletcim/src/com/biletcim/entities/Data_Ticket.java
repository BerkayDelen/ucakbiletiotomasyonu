package com.biletcim.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Data_Ticket {
	
	
	private int Id;
	
	
	private String ticketNumber;
	
	
	private String kalkisZamani;
	
	
	
	
	private String varisZamani;
	
	
	private String sure;
	
	
	
	
	
	private String kalkisYeri;
	
	
	private String varisYeri;
	
	
	private double fiyat;
	
	
	private String Plane_Name;
	
	
	private String Plane_Model;
	
	
	
	
	
	
	 public String getPlane_Name() {
		return Plane_Name;
	}



	public void setPlane_Name(String plane_Name) {
		Plane_Name = plane_Name;
	}



	public String getPlane_Model() {
		return Plane_Model;
	}



	public void setPlane_Model(String plane_Model) {
		Plane_Model = plane_Model;
	}






	/*
	 private Data_Company company;
	 
	 
	 private Data_TicketsSaveDate save_date;
	 */
	 /*@ManyToOne
	 @JoinColumn(name = "ucak", referencedColumnName = "Plane_id")
	 private Data_Plane plane;
*/
	

	
	
	








	


	 public Data_Ticket( ) {
		 super();
	 }



	public Data_Ticket( 
			String ticketNumber,
			String kalkisZamani,
			String varisZamani,
			String sure,
			Data_Plane plane,
			String kalkisYeri,
			String varisYeri,
			double fiyat,
			Data_TicketsSaveDate save_date,
			Data_Company company) {
		
		
		this.ticketNumber = ticketNumber;
		this.kalkisZamani = kalkisZamani;
		this.varisZamani = varisZamani;
		this.sure = sure;
		this.Plane_Name = plane.getPlane_Name();
		this.Plane_Model = plane.getPlane_Model();
		this.kalkisYeri = kalkisYeri;
		this.varisYeri = varisYeri;
		this.fiyat = fiyat;
		
	}






	public int getId() {
		return Id;
	}






	public void setId(int id) {
		Id = id;
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






	public double getFiyat() {
		return fiyat;
	}






	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}













	


	
	
	
	

}
