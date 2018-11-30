package com.niit.Gadgets;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Supplier;

public class ProductTest 
{
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit");
	ctx.refresh();
	
	Product pro=(Product)ctx.getBean("product");
	ProductDao proDao=(ProductDao)ctx.getBean("productDao");
	
	Category cat=(Category)ctx.getBean("category");
	CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
	
	Supplier sup=(Supplier)ctx.getBean("supplier");
	SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");

	
	
	
	pro.setProductId("1222");
	pro.setProductName("bhuvan");
	pro.setProductPrice(2000.0);
	pro.setProductQuantity("3");
	pro.setProductDescription("ddddd");
	cat=catDao.getCategory("1222");
	pro.setCategory(cat);
	sup=supDao.getSupplier("1005");
	pro.setSupplier(sup);
	
	
	
	
	
	
	if(proDao.saveorupdate(pro)==true)
	{
		System.out.println("product saved");
		
	}
	else
	{
		System.out.println("product not saved");
	}
	
	
	pro.setProductId("1223");
	pro.setProductName("bhuvan1");
	pro.setProductPrice(20004.7);
	pro.setProductQuantity("32");
	pro.setProductDescription("eeddddd");
	cat=catDao.getCategory("1223320");
	pro.setCategory(cat);
	sup=supDao.getSupplier("1003");
	pro.setSupplier(sup);
	
	
	
	
	if(proDao.saveorupdate(pro)==true)
	{
		System.out.println("product saved");
		
	}
	else
	{
		System.out.println("product not saved");
	}
	
	
	pro.setProductId("1224");
	pro.setProductName("bhuvan2");
	pro.setProductPrice(200045.7);
	pro.setProductQuantity("322");
	pro.setProductDescription("eetddddd");
	cat=catDao.getCategory("1222");
	pro.setCategory(cat);
	sup=supDao.getSupplier("1005");
	pro.setSupplier(sup);

	if(proDao.saveorupdate(pro)==true)
	{
		System.out.println("product saved");
		
	}
	else
	{
		System.out.println("product not saved");
	}
	
	
	pro=proDao.getProduct("1223");
	if(pro!=null)
	{
		System.out.println(pro.getProductId());
		System.out.println(pro.getProductName());
		System.out.println(pro.getProductPrice());
		System.out.println(pro.getProductQuantity());
		System.out.println(pro.getProductDescription());
		
		
	}
		
	else
	{
		System.out.println("Produt details not found");
	}
		
		pro=proDao.getProduct("1222");
		if(pro!=null)
		{
			System.out.println("Product being deleted");
			if(proDao.delete(pro)==true)
			{
				System.out.println("Product deleted");
			}
			else
			{
				System.out.println("Product not deleted");
				
			}
		}
			else
			{
				System.out.println("Product details not fouund");
			}
			
			List<Product> productlist=proDao.Productlist();
			for(Product p : productlist)
			{
				System.out.println(p.getProductId());
				System.out.println(p.getProductName());
				System.out.println(p.getProductPrice());
				System.out.println(p.getProductQuantity());
				System.out.println(p.getProductDescription());
				
			}
}
}
	/*Product p=new Product();
	p.setProductId("1002");
	p.setProductName("bondi");
	p.setProductPrice("100");
	p.setProductQuantity("3");
	p.setProductDescription("hello");
	System.out.println(p.getProductId());
	System.out.println(p.getProductName());
	System.out.println(p.getProductPrice());
	System.out.println(p.getProductQuantity());
	System.out.println(p.getProductDescription());

*/

