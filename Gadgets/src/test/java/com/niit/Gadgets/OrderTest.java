package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.BillingDao;
import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.OrderDao;
import com.niit.Gadgets.Dao.PayDao;
import com.niit.Gadgets.Dao.ShippingDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Billing;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.Order;
import com.niit.Gadgets.Model.Pay;
import com.niit.Gadgets.Model.Shipping;
import com.niit.Gadgets.Model.User;

public class OrderTest 
{
	public static void main(String args[])
	{
	
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit");
	ctx.refresh();
	
	Order orr=(Order)ctx.getBean("order");
	OrderDao orrDao=(OrderDao)ctx.getBean("orderDao");
	
	Billing car=(Billing)ctx.getBean("billing");
	BillingDao carDao=(BillingDao)ctx.getBean("billingDao");
	
	Pay pa=(Pay)ctx.getBean("pay");
	PayDao paDao=(PayDao)ctx.getBean("payDao");
	
	Shipping shi=(Shipping)ctx.getBean("shipping");
	ShippingDao shiDao=(ShippingDao)ctx.getBean("shippingDao");
	
	User usr=(User)ctx.getBean("user");
	UserDao usrDao=(UserDao)ctx.getBean("userDao");
	
	
	orr.setOrder_Id("1");
	orr.setGrand_Total(110.0);
	orr.setOrder_Date("20th sep");
	orr.setOrder_Time("9:00:00 am");
	
	car=carDao.getBilling("1");
	orr.setBilling(car);
	
	pa=paDao.getPay("1");
	orr.setPay(pa);
	
	shi=shiDao.getShipping("1");
	orr.setShipping(shi);
	
	usr=usrDao.getUser("2");
	orr.setUser(usr);
	if(orrDao.saveorupdate(orr)==true)
	{
		System.out.println("Order saved");
		
	}
	else
	{
		System.out.println("order not saved");
	}
	
	orr.setOrder_Id("2");
	orr.setGrand_Total(100.0);
	orr.setOrder_Date("21th sep");
	orr.setOrder_Time("5:00:00 am");
	
	car=carDao.getBilling("2");
	orr.setBilling(car);
	
	pa=paDao.getPay("2");
	orr.setPay(pa);
	
	shi=shiDao.getShipping("2");
	orr.setShipping(shi);
	
	usr=usrDao.getUser("3");
	orr.setUser(usr);
	
	if(orrDao.saveorupdate(orr)==true)
	{
		System.out.println("Order saved");
		
	}
	else
	{
		System.out.println("order not saved");
	}

	orr.setOrder_Id("3");
	orr.setGrand_Total(1110.0);
	orr.setOrder_Date("19th sep");
	orr.setOrder_Time("8:00:00 am");
	car=carDao.getBilling("3");
	orr.setBilling(car);
	
	pa=paDao.getPay("3");
	orr.setPay(pa);
	
	shi=shiDao.getShipping("3");
	orr.setShipping(shi);
	
	usr=usrDao.getUser("33");
	orr.setUser(usr);
	
	if(orrDao.saveorupdate(orr)==true)
	{
		System.out.println("Order saved");
		
	}
	else
	{
		System.out.println("order not saved");
	}
	
	orr=orrDao.getOrder("1");
	if(orr!=null)
	{
		System.out.println(orr.getOrder_Id());
		System.out.println(orr.getGrand_Total());
		System.out.println(orr.getOrder_Date());
		System.out.println(orr.getOrder_Time());
	}
		
	else
	{
		System.out.println("order details not found");
	}
	
	orr=orrDao.getOrder("2");
	if(orr!=null)
	{
		System.out.println("order being deleted");
		if(orrDao.delete(orr)==true)
		{
			System.out.println("Order deleted");
		}
		else
		{
			System.out.println("order not deleted");
			
		}
	}
		else
		{
			System.out.println("order details not fouund");
		}
		
		List<Order> orderlist=orrDao.Orderlist();
		for(Order c : orderlist)
		{
			System.out.println(c.getOrder_Id());
			System.out.println(c.getGrand_Total());
			System.out.println(c.getOrder_Date());
			System.out.println(c.getOrder_Time());
		}
}
}

	
	
	
