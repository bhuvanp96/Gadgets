package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.ShippingDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.Shipping;
import com.niit.Gadgets.Model.User;

public class ShippingTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		Shipping shi=(Shipping)ctx.getBean("shipping");
		ShippingDao shiDao=(ShippingDao)ctx.getBean("shippingDao");
		
		User usr=(User)ctx.getBean("user");
		UserDao usrDao=(UserDao)ctx.getBean("userDao");
		
		shi.setShipId("1");
		shi.setAddress("bangalore");
		shi.setCity("bangalore");
		shi.setState("karnatake");
		shi.setPincode(560091);
		shi.setCountry("India");
		shi.setPhone(974015855);
		usr=usrDao.getUser("2");
		shi.setUser(usr);

		if(shiDao.saveorupdate(shi)==true)
		{
			System.out.println("shipping saved");
			
		}
		else
		{
			System.out.println("shipping not saved");
		}
		
		shi.setShipId("2");
		shi.setAddress("bangalore");
		shi.setCity("bangalore");
		shi.setState("karnatake");
		shi.setPincode(560091);
		shi.setCountry("India");
		shi.setPhone(974015855);
		usr=usrDao.getUser("3");
		shi.setUser(usr);

		if(shiDao.saveorupdate(shi)==true)
		{
			System.out.println("shipping saved");
			
		}
		else
		{
			System.out.println("shipping not saved");
		}
		
		shi.setShipId("3");
		shi.setAddress("bangalore");
		shi.setCity("bangalore");
		shi.setState("karnatake");
		shi.setPincode(560091);
		shi.setCountry("India");
		shi.setPhone(974015855);
		usr=usrDao.getUser("33");
		shi.setUser(usr);

		if(shiDao.saveorupdate(shi)==true)
		{
			System.out.println("shipping saved");
			
		}
		else
		{
			System.out.println("shipping not saved");
		}
		
		shi=shiDao.getShipping("1");
		if(shi!=null)
		{
			System.out.println(shi.getShipId());
			System.out.println(shi.getAddress());
			System.out.println(shi.getCity());
			System.out.println(shi.getState());
			System.out.println(shi.getPincode());
			System.out.println(shi.getCountry());
			System.out.println(shi.getPhone());
		}
			
		else
		{
			System.out.println("Cart details not found");
		}
		shi=shiDao.getShipping("2");
		if(shi!=null)
		{
			System.out.println("shipping being deleted");
			if(shiDao.delete(shi)==true)
			{
				System.out.println("shipiing deleted");
			}
			else
			{
				System.out.println("shipping not deleted");
				
			}
		}
			else
			{
				System.out.println("shipping details not fouund");
			}
			
			List<Shipping> shippinglist=shiDao.Shippinglist();
			for(Shipping c : shippinglist)
			{
				System.out.println(c.getShipId());
				System.out.println(c.getAddress());
				System.out.println(c.getCity());
				System.out.println(c.getState());
				System.out.println(c.getPincode());
				System.out.println(c.getCountry());
				System.out.println(c.getPhone());			}
}
	
		
		
		
		
}
	
	
	
	
