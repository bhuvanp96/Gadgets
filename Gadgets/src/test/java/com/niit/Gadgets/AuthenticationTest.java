package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.AuthenticationDao;
import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Model.Authentication;
import com.niit.Gadgets.Model.Category;

public class AuthenticationTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		Authentication aut=(Authentication)ctx.getBean("authentication");
		AuthenticationDao autDao=(AuthenticationDao)ctx.getBean("authenticationDao");
		
		aut.setrId("1");
		aut.setRole_name("role_user");
		aut.setUsername("bhuvan");
		
		if(autDao.saveorupdate(aut)==true)
		{
			System.out.println("authentication saved");
			
		}
		else
		{
			System.out.println("authentication not saved");
		}
		
		aut.setrId("2");
		aut.setRole_name("role_user");
		aut.setUsername("bhuvan1");
		
		if(autDao.saveorupdate(aut)==true)
		{
			System.out.println("authentication saved");
			
		}
		else
		{
			System.out.println("authentication not saved");
		}
		
		aut.setrId("3");
		aut.setRole_name("role_user");
		aut.setUsername("bhuvan2");
		
		if(autDao.saveorupdate(aut)==true)
		{
			System.out.println("authentication saved");
			
		}
		else
		{
			System.out.println("authentication not saved");
		}
		
		aut=autDao.getAuthentication("1");
		if(aut!=null)
		{
			System.out.println(aut.getrId());
			System.out.println(aut.getRole_name());
			System.out.println(aut.getUsername());
		}
			
		else
		{
			System.out.println("Authentication details not found");
		}
		
		aut=autDao.getAuthentication("2");
		if(aut!=null)
		{
			System.out.println("Authentication being deleted");
			if(autDao.delete(aut)==true)
			{
				System.out.println("authentication deleted");
			}
			else
			{
				System.out.println("authentication not deleted");
				
			}
		}
			else
			{
				System.out.println("authentication details not fouund");
			}
			
			List<Authentication> authenticationlist=autDao.Authenticationlist();
			for(Authentication a : authenticationlist)
			{
				System.out.println(a.getrId());
				System.out.println(a.getRole_name());
				System.out.println(a.getUsername());
			}
}
}

		
		
		
		
		
		

