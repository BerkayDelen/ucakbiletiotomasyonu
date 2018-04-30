package com.biletcim.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seats {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "seat_ID")
	private int Id;
	
	@Column(name = "sales_id")
	private int sales_id;
	
	@Column(name = "seat_Number")
	private String seat_Number;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSales_id() {
		return sales_id;
	}

	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}

	public String getSeat_Number() {
		return seat_Number;
	}

	public void setSeat_Number(String seat_Number) {
		this.seat_Number = seat_Number;
	}
	
	
	
}
