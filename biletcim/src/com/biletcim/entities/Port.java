package com.biletcim.entities;

public class Port {
	
	private String PortName;
	private String Code;
	private String City;
	private String Country;
	
	private double CoordinateLatitude;
	private double CoordinateLongitude;
	public Port(String portName, String code, String city, String country, double coordinateLatitude,
			double coordinateLongitude) {
		super();
		PortName = portName;
		Code = code;
		City = city;
		Country = country;
		CoordinateLatitude = coordinateLatitude;
		CoordinateLongitude = coordinateLongitude;
	}
	
	public String getPortName() {
		return PortName;
	}
	public void setPortName(String portName) {
		PortName = portName;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public double getCoordinateLatitude() {
		return CoordinateLatitude;
	}
	public void setCoordinateLatitude(double coordinateLatitude) {
		CoordinateLatitude = coordinateLatitude;
	}
	public double getCoordinateLongitude() {
		return CoordinateLongitude;
	}
	public void setCoordinateLongitude(double coordinateLongitude) {
		CoordinateLongitude = coordinateLongitude;
	}
	
	
	
	
	
	
	
	
}
