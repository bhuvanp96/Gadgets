package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.AuthenticationDao;
import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Model.Authentication;
import com.niit.Gadgets.Model.Cart;

public class CartTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		Cart carr=(Cart)ctx.getBean("cart");
		CartDao carrDao=(CartDao)ctx.getBean("cartDao");
		
		
		carr.setCart_Id("1");
		carr.setGrand_total(0.0);
		carr.setTotal_items(0);
		
		if(carrDao.saveorupdate(carr)==true)
		{
			System.out.println("cart saved");
			
		}
		else
		{
			System.out.println("cart not saved");
		}
		

		carr.setCart_Id("2");
		carr.setGrand_total(0.0);
		carr.setTotal_items(0);
		
		if(carrDao.saveorupdate(carr)==true)
		{
			System.out.println("cart saved");
			
		}
		else
		{
			System.out.println("cart not saved");
		}
		
		carr.setCart_Id("3");
		carr.setGrand_total(0.0);
		carr.setTotal_items(0);
		
		if(carrDao.saveorupdate(carr)==true)
		{
			System.out.println("cart saved");
			
		}
		else
		{
			System.out.println("cart not saved");
		}
		
		carr=carrDao.getCart("1");
		if(carr!=null)
		{
			System.out.println(carr.getCart_Id());
			System.out.println(carr.getGrand_total());
			System.out.println(carr.getTotal_items());
		}
			
		else
		{
			System.out.println("Cart details not found");
		}
		
		carr=carrDao.getCart("2");
		if(carr!=null)
		{
			System.out.println("Cart being deleted");
			if(carrDao.delete(carr)==true)
			{
				System.out.println("cart deleted");
			}
			else
			{
				System.out.println("cart not deleted");
				
			}
		}
			else
			{
				System.out.println("cart details not fouund");
			}
			
			List<Cart> cartlist=carrDao.Cartlist();
			for(Cart c : cartlist)
			{
				System.out.println(c.getCart_Id());
				System.out.println(c.getGrand_total());
				System.out.println(c.getTotal_items());
			}
}
}

		

