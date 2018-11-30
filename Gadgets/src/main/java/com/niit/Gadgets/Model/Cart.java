package com.niit.Gadgets.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart 

{
@Id
	private String Cart_Id;
	private Double Grand_total=0.0;
	private int Total_items=0;
	
	@OneToOne
	@JoinColumn(name="UserId")
	private User user;
	
	public Cart()
	{
		this.Cart_Id="Cart"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartItems;

	public String getCart_Id() {
		return Cart_Id;
	}

	public void setCart_Id(String cart_Id) {
		Cart_Id = cart_Id;
	}

	public Double getGrand_total() {
		return Grand_total;
	}

	public void setGrand_total(Double grand_total) {
		Grand_total = grand_total;
	}

	public int getTotal_items() {
		return Total_items;
	}

	public void setTotal_items(int total_items) {
		Total_items = total_items;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
