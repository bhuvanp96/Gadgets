package com.niit.GadgetsFrontEnd1.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.User;

@Controller
public class HomeController 
{

	@Autowired
	User user;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView MV=new ModelAndView("index");
		MV.addObject("user",user);
		List<Product> prolist= productDao.Productlist();
		MV.addObject("products", prolist);
		return MV;
		
	}
	
	@RequestMapping("/header")
	public ModelAndView header()
	{
		ModelAndView MV=new ModelAndView();
		MV.addObject("user",user);
		MV.setViewName("header");
		return MV;
		
	}
	
	@RequestMapping("/footer")
	public ModelAndView footer()
	{
		ModelAndView MV=new ModelAndView();
		MV.addObject("user",user);
		MV.setViewName("footer");
		return MV;
		
	}
	
	
}
