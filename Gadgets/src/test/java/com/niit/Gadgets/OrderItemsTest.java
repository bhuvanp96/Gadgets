package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.OrderDao;
import com.niit.Gadgets.Dao.OrderItemsDao;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.Order;
import com.niit.Gadgets.Model.OrderItems;

public class OrderItemsTest 
{

	public static void main(String args[])
	{
	
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit");
	ctx.refresh();
	
	OrderItems or=(OrderItems)ctx.getBean("orderItems");
	OrderItemsDao orDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
	Order orr=(Order)ctx.getBean("order");
	OrderDao orrDao=(OrderDao)ctx.getBean("orderDao");
	
	or.setOrderitem_Id("1");
	or.setProduct_Id("123");
	orr=orrDao.getOrder("1");
	or.setOrder(orr);
	
	if(orDao.saveorupdate(or)==true)
	{
		System.out.println("orderItems saved");
		
	}
	else
	{
		System.out.println("orderitmes not saved");
	}

	or.setOrderitem_Id("2");
	or.setProduct_Id("1234");
	orr=orrDao.getOrder("2");
	or.setOrder(orr);
	
	
	
	if(orDao.saveorupdate(or)==true)
	{
		System.out.println("orderItems saved");
		
	}
	else
	{
		System.out.println("orderitmes not saved");
	}

	or.setOrderitem_Id("3");
	or.setProduct_Id("12355");
	orr=orrDao.getOrder("3");
	or.setOrder(orr);
	

	
	if(orDao.saveorupdate(or)==true)
	{
		System.out.println("orderItems saved");
		
	}
	else
	{
		System.out.println("orderitmes not saved");
	}

	or=orDao.getOrderItems("1");
	if(or!=null)
	{
		System.out.println(or.getOrderitem_Id());
		System.out.println(or.getProduct_Id());
		
	}
		
	else
	{
		System.out.println("Orderitems details not found");
	}
	
	or=orDao.getOrderItems("2");
	if(or!=null)
	{
		System.out.println("orderitems being deleted");
		if(orDao.delete(or)==true)
		{
			System.out.println("orderitmes deleted");
		}
		else
		{
			System.out.println("orderitems not deleted");
			
		}
	}
		else
		{
			System.out.println("orderitems details not fouund");
		}
		
		List<OrderItems> orderitemslist=orDao.OrderItemslist();
		for(OrderItems c : orderitemslist)
		{
			System.out.println(c.getOrderitem_Id());
			System.out.println(c.getProduct_Id());
			
		}
}
}


