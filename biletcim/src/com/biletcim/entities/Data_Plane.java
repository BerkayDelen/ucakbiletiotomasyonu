package com.biletcim.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


public class Data_Plane {
	
	
	private int Id;
	
	
	
	private String Plane_Name;
	
	
	private String Plane_Model;
	
	
	
	 private Set<Data_Ticket> data_Ticket;
	
	 public Data_Plane() {
		 super();
		}

	public Data_Plane(String plane_Name, String plane_Model) {
		
		Plane_Name = plane_Name;
		Plane_Model = plane_Model;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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
	
	
	
	
	

}
