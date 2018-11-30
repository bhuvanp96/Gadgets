package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.Supplier;
import com.niit.Gadgets.Model.User;

public class UserTest
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		User usr=(User)ctx.getBean("user");
		UserDao usrDao=(UserDao)ctx.getBean("userDao");
		
		usr.setUserId("2");
		usr.setUserName("boron");
		usr.setUserEmailId("Bhuan.ppp@gmailcom");
		usr.setUserPassword("bbbbb");
		usr.setUserPhno("9740158555");
		usr.setUserAddress("mimbai");
		
		if(usrDao.saveorupdate(usr)==true)
		{
			System.out.println("user saved");
			
		}
		else
		{
			System.out.println("user not saved");
		}
		
		usr.setUserId("3");
		usr.setUserName("borrron");
		usr.setUserEmailId("Bhuan.ppp@gmailcom");
		usr.setUserPassword("bbbbb");
		usr.setUserPhno("9740158555");
		usr.setUserAddress("mimbai");
		
		if(usrDao.saveorupdate(usr)==true)
		{
			System.out.println("user saved");
			
		}
		else
		{
			System.out.println("user not saved");
		}
		
		
		usr.setUserId("33");
		usr.setUserName("boffron");
		usr.setUserEmailId("Bhuan.ppp@gmailcom");
		usr.setUserPassword("bbbbb");
		usr.setUserPhno("9740158555");
		usr.setUserAddress("mimbai");
		
		if(usrDao.saveorupdate(usr)==true)
		{
			System.out.println("user saved");
			
		}
		else
		{
			System.out.println("user not saved");
		}
		
		
		usr=usrDao.getUser("33");
		if(usr!=null)
		{
			System.out.println(usr.getUserId());
			System.out.println(usr.getUserName());
			System.out.println(usr.getUserEmailId());
			System.out.println(usr.getUserPassword());
			System.out.println(usr.getUserPhno());
			System.out.println(usr.getUserAddress());
			
		}
			
		else
		{
			System.out.println("User details not found");
		}
		
		
		usr=usrDao.getUser("3");
		if(usr!=null)
		{
			System.out.println("User being deleted");
			if(usrDao.delete(usr)==true)
			{
				System.out.println("User deleted");
			}
			else
			{
				System.out.println("user not deleted");
				
			}
		}
			else
			{
				System.out.println("user details not fouund");
			}
			
			List<User> userlist=usrDao.Userlist();
			for(User u : userlist)
			{
				System.out.println(u.getUserId());
				System.out.println(u.getUserName());
				System.out.println(u.getUserEmailId());
				System.out.println(u.getUserPassword());
				System.out.println(u.getUserPhno());
				System.out.println(u.getUserAddress());
				
			}
}
}
		
		
		/*
		  
		 
		User u=new User();
		u.setUserId("2");
		u.setUserName("boron");
		u.setUserEmailId("Bhuan.ppp@gmailcom");
		u.setUserPassword("bbbbb");
		u.setUserPhno("9740158555");
		u.setUserAddress("mimbai");
		System.out.println(u.getUserId());
		System.out.println(u.getUserName());
		System.out.println(u.getUserEmailId());
		System.out.println(u.getUserPassword());
		System.out.println(u.getUserPhno());
		System.out.println(u.getUserAddress());
	*/
	
	
