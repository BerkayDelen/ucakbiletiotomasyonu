package com.biletcim.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planes")
public class Plane {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Plane_id")
	private int id;
	
	@Column(name = "Plane_Name")
	private String Plane_Name;
	
	@Column(name = "Plane_Model")
	private String Plane_Model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Plane( String plane_Name, String plane_Model) {
		super();
		
		Plane_Name = plane_Name;
		Plane_Model = plane_Model;
	}

	
	
	
	
	
	
}
