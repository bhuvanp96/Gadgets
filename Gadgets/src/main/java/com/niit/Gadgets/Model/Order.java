package com.niit.Gadgets.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table (name="Orders")
@Component
public class Order 
{
	@Id
	
	private String Order_Id;
	private Double Grand_Total;
	private String Order_Date;
	private String Order_Time;
	
	public Order()
	{
		this.Order_Id="Order"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@OneToOne
	@JoinColumn(name="BillingId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="UserId")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Pay_Id")
	private Pay pay;
	
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderitems;

	public String getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}

	public Double getGrand_Total() {
		return Grand_Total;
	}

	public void setGrand_Total(Double grand_Total) {
		Grand_Total = grand_Total;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}

	public String getOrder_Time() {
		return Order_Time;
	}

	public void setOrder_Time(String order_Time) {
		Order_Time = order_Time;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public List<OrderItems> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItems> orderitems) {
		this.orderitems = orderitems;
	}

	

	
	
	
	
	
}
