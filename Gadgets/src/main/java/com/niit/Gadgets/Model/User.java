package com.niit.Gadgets.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User 
{
	
	@Id
	private String UserId;
	private String UserName;
	private String UserEmailId;
	private String UserPassword;
	private String UserPhno;
	private String UserAddress;
	
	
	public User()
	{
		this.UserId="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BillingId")
	private Billing billing;
	
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserEmailId() {
		return UserEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		UserEmailId = userEmailId;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserPhno() {
		return UserPhno;
	}
	public void setUserPhno(String userPhno) {
		UserPhno = userPhno;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	
	
}
