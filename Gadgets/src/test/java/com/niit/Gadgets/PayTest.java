package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.PayDao;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.Pay;

public class PayTest 
{
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit");
	ctx.refresh();
	
	Pay pa=(Pay)ctx.getBean("pay");
	PayDao paDao=(PayDao)ctx.getBean("payDao");
	
	
	pa.setPay_Id("1");
	pa.setPay_Method("cash");
	pa.setStatus("confirmed");
	
	if(paDao.saveorupdate(pa)==true)
	{
		System.out.println("pay saved");
		
	}
	else
	{
		System.out.println("pay not saved");
	}
	
	pa.setPay_Id("2");
	pa.setPay_Method("cash");
	pa.setStatus("failed");
	
	if(paDao.saveorupdate(pa)==true)
	{
		System.out.println("pay saved");
		
	}
	else
	{
		System.out.println("pay not saved");
	}
	
	pa.setPay_Id("3");
	pa.setPay_Method("cash");
	pa.setStatus("confirmed");
	
	if(paDao.saveorupdate(pa)==true)
	{
		System.out.println("pay saved");
		
	}
	else
	{
		System.out.println("pay not saved");
	}
	
	pa=paDao.getPay("1");
	if(pa!=null)
	{
		System.out.println(pa.getPay_Id());
		System.out.println(pa.getPay_Method());
		System.out.println(pa.getStatus());
	}
		
	else
	{
		System.out.println("pay details not found");
	}
	
	pa=paDao.getPay("2");
	if(pa!=null)
	{
		System.out.println("pay being deleted");
		if(paDao.delete(pa)==true)
		{
			System.out.println("pay deleted");
		}
		else
		{
			System.out.println("pay not deleted");
			
		}
	}
		else
		{
			System.out.println("pay details not fouund");
		}
		
		List<Pay> paylist=paDao.Paylist();
		for(Pay c : paylist)
		{
			System.out.println(c.getPay_Id());
			System.out.println(c.getPay_Method());
			System.out.println(c.getStatus());
		}
}

	}
	
	
	
	
