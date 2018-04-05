package com.biletcim.entities;

public class Seat {
	
	private int id;
	private int item_id;
	private String seat_character;
	private String seat_number;
	private String coords;
	private String description;
	private String _class;
	
	public Seat(int id, int item_id, String seat_character, String seat_number, String coords, String description,
			String _class) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.seat_character = seat_character;
		this.seat_number = seat_number;
		this.coords = coords;
		this.description = description;
		this._class = _class;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getSeat_character() {
		return seat_character;
	}
	public void setSeat_character(String seat_character) {
		this.seat_character = seat_character;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public String getCoords() {
		return coords;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	
	
	
	
	
	
	
	

}
