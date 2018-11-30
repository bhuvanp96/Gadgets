package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Supplier;

public class SupplierTest 
{
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit");
	ctx.refresh();
	
	Supplier sup=(Supplier)ctx.getBean("supplier");
	SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
	
	sup.setSupplierId("1003");
	sup.setSupplierName("Goku");
	sup.setSupplierAddress("Rajajinagar");
	sup.setSupplierPhno("9740158555");
	sup.setSupplierEmailId("Bhuvan.096@gmail.com");
	sup.setSupplierPassword("Ttttttt");
	if(supDao.saveorupdate(sup)==true)
	{
		System.out.println("supplier saved");
		
	}
	else
	{
		System.out.println("supplier not saved");
	}
	
	
	sup.setSupplierId("1004");
	sup.setSupplierName("Gokuu");
	sup.setSupplierAddress("Rajaajinagar");
	sup.setSupplierPhno("97401583555");
	sup.setSupplierEmailId("Bhuvann.096@gmail.com");
	sup.setSupplierPassword("Tttttdtt");
	if(supDao.saveorupdate(sup)==true)
	{
		System.out.println("supplier saved");
		
	}
	else
	{
		System.out.println("supplier not saved");
	}
	
	sup.setSupplierId("1005");
	sup.setSupplierName("Gokuuu");
	sup.setSupplierAddress("Raajaajinagar");
	sup.setSupplierPhno("974015483555");
	sup.setSupplierEmailId("Bhuvaann.096@gmail.com");
	sup.setSupplierPassword("Ttttdtt");
	if(supDao.saveorupdate(sup)==true)
	{
		System.out.println("supplier saved");
		
	}
	else
	{
		System.out.println("supplier not saved");
	}
	
	
	sup=supDao.getSupplier("1005");
	if(sup!=null)
	{
		System.out.println(sup.getSupplierId());
		System.out.println(sup.getSupplierName());
		System.out.println(sup.getSupplierAddress());
		System.out.println(sup.getSupplierPhno());
		System.out.println(sup.getSupplierEmailId());
		System.out.println(sup.getSupplierPassword());
		
	}
		
	else
	{
		System.out.println("Supplier details not found");
	}
	
	
	sup=supDao.getSupplier("1004");
	if(sup!=null)
	{
		System.out.println("Supplier being deleted");
		if(supDao.delete(sup)==true)
		{
			System.out.println("supplier deleted");
		}
		else
		{
			System.out.println("supplier not deleted");
			
		}
	}
		else
		{
			System.out.println("supplier details not fouund");
		}
		
		List<Supplier> supplierlist=supDao.Supplierlist();
		for(Supplier s : supplierlist)
		{
			System.out.println(s.getSupplierId());
			System.out.println(s.getSupplierName());
			System.out.println(s.getSupplierAddress());
			System.out.println(s.getSupplierPhno());
			System.out.println(s.getSupplierEmailId());
			System.out.println(s.getSupplierPassword());
			
		}
}
}
	/*Supplier s= new Supplier();
	s.setSupplierId("1003");
	s.setSupplierName("Goku");
	s.setSupplierAddress("Rajajinagar");
	s.setSupplierPhno("9740158555");
	s.setSupplierEmailId("Bhuvan.096@gmail.com");
	s.setSupplierPassword("Ttttttt");
	System.out.println(s.getSupplierId());
	System.out.println(s.getSupplierName());
	System.out.println(s.getSupplierAddress());
	System.out.println(s.getSupplierPhno());
	System.out.println(s.getSupplierEmailId());
	System.out.println(s.getSupplierPassword());
	
*/

