package com.biletcim.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="ticketssavedate")
public class Data_TicketsSaveDate {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TicketGroup_id")
	private int Id;
	
	@Column(name="TicketGroup_SaveDate")
	private Date SaveDate;
	
	@Column(name="kalkisYeri")
	private String kalkisYeri;
	
	@Column(name="varisYeri")
	private String varisYeri;
	
	
	@PrePersist
    public void preUpdateAndPersist() {
        this.SaveDate = new Date();
    }
	
	
	 public Data_TicketsSaveDate() {
			super();
			
		}
	 
	public Data_TicketsSaveDate( String kalkisYeri, String varisYeri) {
		
		
		this.kalkisYeri = kalkisYeri;
		this.varisYeri = varisYeri;
	}
	



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getSaveDate() {
		return SaveDate;
	}

	public void setSaveDate(Date saveDate) {
		SaveDate = saveDate;
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
	 
	
	
	
}
