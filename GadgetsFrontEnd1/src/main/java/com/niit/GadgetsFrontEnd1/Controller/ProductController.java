package com.niit.GadgetsFrontEnd1.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Supplier;
import com.niit.GadgetsFrontEnd1.FileInput.FileInput;

@Controller
public class ProductController
{
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	String path="C:\\Users\\Bhuvan P\\eclipse-workspace\\GadgetsFrontEnd1\\src\\main\\webapp\\resources\\images\\";
	
	
	
	@RequestMapping("/Product")
	public ModelAndView Productform()
	{
	ModelAndView MV=new ModelAndView();
	MV.addObject("Product",new Product());
	List<Product> productlist = productDao.Productlist();
	MV.addObject("Products",productlist);
	List<Category> catlist = categoryDao.Categorylist();
	List<Supplier> suplist = supplierDao.Supplierlist();
	MV.addObject("categories",catlist);
	MV.addObject("Suppliers",suplist);
	MV.setViewName("Product");
	return MV ;
	}


	@RequestMapping("/addproduct")
	public ModelAndView addproduct(@ModelAttribute("Product")Product product)
	{
	ModelAndView MV=new ModelAndView();
	
	FileInput.upload(path, product.getPimg(), product.getProductId()+".jpg");
	MV.setViewName("Product");
	
	if(productDao.saveorupdate(product)==true)
	{
	MV.addObject("Msg","product saved");
	}
	else
	{
	MV.addObject("Msg","product Not saved");
	
	}
	MV.setViewName("redirect:/Product");
	return MV;
	}


	@RequestMapping("/editproduct/{ProductId}")
	public ModelAndView editproduct(@PathVariable("ProductId")String ProductId)
	{ 
	ModelAndView MV=new ModelAndView("Product");
	product=productDao.getProduct(ProductId);
	MV.addObject("Product",product);
	List<Product> productlist = productDao.Productlist();
	MV.addObject("Products",productlist);
	List<Category> catlist = categoryDao.Categorylist();
	List<Supplier> suplist = supplierDao.Supplierlist();
	MV.addObject("categories",catlist);
	MV.addObject("Suppliers",suplist);
	return MV;
	}


	@RequestMapping("/deleteproduct/{ProductId}")
	public ModelAndView deleteproduct(@PathVariable("ProductId")String productId)
	{
	ModelAndView MV=new ModelAndView();
	product=productDao.getProduct(productId);
	if(productDao.delete(product)==true)
	{
	MV.addObject("Msg1","product deleted");
	}
	else
	{
	MV.addObject("Msg1","product Not deleted");
	}
	MV.setViewName("redirect:/Product");
	return MV;
	}

}
