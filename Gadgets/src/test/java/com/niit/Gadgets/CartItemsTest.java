package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.CartItemsDao;
import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.CartItems;
import com.niit.Gadgets.Model.Product;

public class CartItemsTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		CartItems car=(CartItems)ctx.getBean("cartItems");
		CartItemsDao carDao=(CartItemsDao)ctx.getBean("cartItemsDao");
		
		Cart carr=(Cart)ctx.getBean("cart");
		CartDao carrDao=(CartDao)ctx.getBean("cartDao");
		
		Product pro=(Product)ctx.getBean("product");
		ProductDao proDao=(ProductDao)ctx.getBean("productDao");
		
		car.setCartitem_Id("1");
		car.setPrice(120);
		
		carr=carrDao.getCart("1");
		car.setCart(carr);
		pro=proDao.getProduct("1223");
		car.setProduct(pro);
		
		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("cartitems saved");
			
		}
		else
		{
			System.out.println("cartitems not saved");
		}
		
		car.setCartitem_Id("2");
		car.setPrice(1200);
		carr=carrDao.getCart("2");
		car.setCart(carr);
		pro=proDao.getProduct("1223");
		car.setProduct(pro);
	
		
		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("cartitems saved");
			
		}
		else
		{
			System.out.println("cartitems not saved");
		}
		
		car.setCartitem_Id("3");
		car.setPrice(1202);
		carr=carrDao.getCart("3");
		car.setCart(carr);
		pro=proDao.getProduct("1224");
		car.setProduct(pro);
	
		
		if(carDao.saveorupdate(car)==true)
		{
			System.out.println("cartitems saved");
			
		}
		else
		{
			System.out.println("cartitems not saved");
		}
		
		car=carDao.getCartItems("1");
		if(car!=null)
		{
			System.out.println(car.getCartitem_Id());
			System.out.println(car.getPrice());
			
		}
			
		else
		{
			System.out.println("Cart details not found");
		}
		
		car=carDao.getCartItems("2");
		if(car!=null)
		{
			System.out.println("CartItems being deleted");
			if(carDao.delete(car)==true)
			{
				System.out.println("cartItems deleted");
			}
			else
			{
				System.out.println("cartItems not deleted");
				
			}
		}
			else
			{
				System.out.println("cartItems details not fouund");
			}
			
			List<CartItems> cartItemslist=carDao.CartItemslist();
			for(CartItems c : cartItemslist)
			{
				System.out.println(c.getCartitem_Id());
				System.out.println(c.getPrice());
			}
}
}

		


		
