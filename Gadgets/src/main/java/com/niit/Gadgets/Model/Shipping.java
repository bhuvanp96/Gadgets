package com.niit.Gadgets.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Shipping 
{
@Id
	private String shipId;


public Shipping()
{
	this.shipId="PROD"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
	public String getShipId() {
	return shipId;
}

public void setShipId(String shipId) {
	this.shipId = shipId;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	private String address;
	private String city;
	private String state;
	private int pincode;
	private String country;
	private int phone;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UserId")
	private User user;

}
