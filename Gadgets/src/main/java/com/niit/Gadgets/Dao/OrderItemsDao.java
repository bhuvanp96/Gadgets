package com.niit.Gadgets.Dao;

import java.util.List;

import com.niit.Gadgets.Model.OrderItems;


public interface OrderItemsDao 
{
	public boolean saveorupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems getOrderItems(String Orderitem_Id);
	public List<OrderItems> OrderItemslist();

}
