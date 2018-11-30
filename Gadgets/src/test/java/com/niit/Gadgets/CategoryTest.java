package com.niit.Gadgets;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Model.Category;

public class CategoryTest 
{
	public static void main(String args[])
	{
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
		
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		
		cat.setCategoryId("1222");
		cat.setCategoryName("bhuvan");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("categpory saved");
			
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		
		
		cat.setCategoryId("123");
		cat.setCategoryName("bhuvan1");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("category saved");
			
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		
		cat.setCategoryId("1223320");
		cat.setCategoryName("bhuvan2");
		if(catDao.saveorupdate(cat)==true)
		{
			System.out.println("categpory saved");
			
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		
		
		
		cat=catDao.getCategory("123");
		if(cat!=null)
		{
			System.out.println(cat.getCategoryId());
			System.out.println(cat.getCategoryName());
			
		}
			
		else
		{
			System.out.println("Category details not found");
		}
			
			cat=catDao.getCategory("123");
			if(cat!=null)
			{
				System.out.println("Category being deleted");
				if(catDao.delete(cat)==true)
				{
					System.out.println("category deleted");
				}
				else
				{
					System.out.println("category not deleted");
					
				}
			}
				else
				{
					System.out.println("category details not fouund");
				}
				
				List<Category> categorylist=catDao.Categorylist();
				for(Category c : categorylist)
				{
					System.out.println(c.getCategoryId());
					System.out.println(c.getCategoryName());
					
				}
	}
}
			
			
			
			
			/*Category c=new Category();
		c.setCategoryId("10001");
		c.setCategoryName("Bhuvan");
		System.out.println(c.getCategoryId());
		System.out.println(c.getCategoryName());*/
	

