package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.BillingDao;
import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Billing;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.User;

public class BillingTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		Billing car=(Billing)ctx.getBean("billing");
		BillingDao carDao=(BillingDao)ctx.getBean("billingDao");
		
		User usr=(User)ctx.getBean("user");
		UserDao usrDao=(UserDao)ctx.getBean("userDao");
		

		car.setBillingId("1");
		car.setBillingName("BHuan");
		car.setBillingAddress("banagkre");
		car.setBillingPhno("9742012855");
		usr=usrDao.getUser("2");
		car.setUser(usr);
		
		
		
		
		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("billing saved");
			
		}
		else
		{
			System.out.println("billing not saved");
		}
	
		car.setBillingId("2");
		car.setBillingName("BHuan");
		car.setBillingAddress("banagkre");
		car.setBillingPhno("9742012855");
		usr=usrDao.getUser("3");
		car.setUser(usr);

		
		
		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("billing saved");
			
		}
		else
		{
			System.out.println("billing not saved");
		}
		
		car.setBillingId("3");
		car.setBillingName("BHuan");
		car.setBillingAddress("banagkre");
		car.setBillingPhno("9742012855");
		usr=usrDao.getUser("33");
		car.setUser(usr);

		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("billing saved");
			
		}
		else
		{
			System.out.println("billing not saved");
		}
		
		car=carDao.getBilling("1");
		if(car!=null)
		{
			System.out.println(car.getBillingId());
			System.out.println(car.getBillingName());
			System.out.println(car.getBillingAddress());
			System.out.println(car.getBillingPhno());
	
		}
		
		
			
		else
		{
			System.out.println("Cart details not found");
		}
		
		
		car=carDao.getBilling("2");
		if(car!=null)
		{
			System.out.println("billing being deleted");
			if(carDao.delete(car)==true)
			{
				System.out.println("billing deleted");
			}
			else
			{
				System.out.println("billing not deleted");
				
			}
		}
			else
			{
				System.out.println("billing details not fouund");
			}
			
			List<Billing> billinglist=carDao.Billinglist();
			for(Billing c : billinglist)
			{
				System.out.println(c.getBillingId());
				System.out.println(c.getBillingName());
				System.out.println(c.getBillingAddress());
				System.out.println(c.getBillingPhno());
		
			}
}

}
	
	
	
