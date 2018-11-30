package com.niit.Gadgets.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems 
{
	@Id
	private String  Orderitem_Id;
	private String Product_Id;
	
	public OrderItems()
	{
		this.Orderitem_Id="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	@ManyToOne
	@JoinColumn(name="Order_Id")
	private Order order;

	public String getOrderitem_Id() {
		return Orderitem_Id;
	}

	public void setOrderitem_Id(String orderitem_Id) {
		Orderitem_Id = orderitem_Id;
	}

	public String getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	

}
