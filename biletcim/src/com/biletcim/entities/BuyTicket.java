package com.biletcim.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;



@Entity
@Table(name="sales")
public class BuyTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sales_id")
	private int Id;
	
	@Column(name = "sales_amount")
	private Double Amount;
	
	@Column(name = "sales_ticket_id")
	private int Ticket_id;
	
	@Column(name = "sales_uuid")
	private String sales_uuid;
	
	@Column(name = "sales_salt")
	private String sales_salt;
	
	
	@Column(name = "sales_user_isLogin")
	private Boolean User_isLogin;
	
	
	@Column(name = "sales_user_Name")
	private String User_ticket_Name;
	
	@Column(name = "sales_user_Surname")
	private String User_ticket_Surname;
	
	
	
	@Column(name = "sales_user_TC")
	private String User_ticket_TC;
	
	@Column(name = "sales_user_Email")
	private String User_ticket_Email;
	
	@Column(name = "sales_user_Birthday")
	private Date User_ticket_Birthday;
	
	@Column(name = "sales_user_gender")
	private Boolean User_ticket_gender;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public int getTicket_id() {
		return Ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		Ticket_id = ticket_id;
	}

	public Boolean getUser_isLogin() {
		return User_isLogin;
	}

	public void setUser_isLogin(Boolean user_isLogin) {
		User_isLogin = user_isLogin;
	}

	public String getUser_ticket_Name() {
		return User_ticket_Name;
	}

	public void setUser_ticket_Name(String user_ticket_Name) {
		User_ticket_Name = user_ticket_Name;
	}

	public String getUser_ticket_Surname() {
		return User_ticket_Surname;
	}

	public void setUser_ticket_Surname(String user_ticket_Surname) {
		User_ticket_Surname = user_ticket_Surname;
	}

	public String getUser_ticket_TC() {
		return User_ticket_TC;
	}

	public void setUser_ticket_TC(String user_ticket_TC) {
		User_ticket_TC = user_ticket_TC;
	}

	public String getUser_ticket_Email() {
		return User_ticket_Email;
	}

	public void setUser_ticket_Email(String user_ticket_Email) {
		User_ticket_Email = user_ticket_Email;
	}

	public Date getUser_ticket_Birthday() {
		return User_ticket_Birthday;
	}

	public void setUser_ticket_Birthday(Date user_ticket_Birthday) {
		User_ticket_Birthday = user_ticket_Birthday;
	}

	public Boolean getUser_ticket_gender() {
		return User_ticket_gender;
	}

	public void setUser_ticket_gender(Boolean user_ticket_gender) {
		User_ticket_gender = user_ticket_gender;
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

	
	
	
	
	

}
