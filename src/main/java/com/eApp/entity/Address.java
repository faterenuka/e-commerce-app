package com.eApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) throws Exception {
		
		if(pincode.matches("[0-9]{6}")) {
			
			this.pincode = pincode;
		}
		else
			throw new Exception("Pincode should have 6 numbers!!!");
	}
	
	public Address() {
		
		super();
	}
	
	public Address(Integer id, String streetNo, String buildingName, String city, String state, String country,
			String pincode) {
		super();
		this.id = id;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	public static void main(String[] args) throws Exception {
		
		Address ad=new Address();
		boolean pc=ad.pincode.matches("[0-9]{6}");
		if(pc) {
			System.out.println("Valid");
		}
		else
			throw new Exception("pin should be of 6 number");
	}
}

