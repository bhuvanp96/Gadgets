package com.niit.GadgetsFrontEnd1.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Model.Category;

@Controller
public class CategoryController
{
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/Category")
	public ModelAndView Categoryform()
	{
	ModelAndView MV=new ModelAndView();
	MV.addObject("category",new Category());
	List<Category> catList = categoryDao.Categorylist();
	MV.addObject("categories",catList);
	MV.setViewName("Category");
	return MV ;
	}


	@RequestMapping("/addcategory")
	public ModelAndView addcategory(@ModelAttribute("category")Category category)
	{
	ModelAndView MV=new ModelAndView();
	if(categoryDao.saveorupdate(category)==true)
	{
	MV.addObject("Msg","Category saved");
	}
	else
	{
	MV.addObject("Msg","Category Not saved");
	}
	MV.setViewName("redirect:/Category");
	return MV;
	}


	@RequestMapping("/editcategory/{CategoryId}")
	public ModelAndView editcategory(@PathVariable("CategoryId")String categoryId)
	{ 
	ModelAndView MV=new ModelAndView("Category");
	category=categoryDao.getCategory(categoryId);
	MV.addObject("category",category);
	List<Category> catList = categoryDao.Categorylist();
	MV.addObject("categories",catList);
	return MV;
	}


	@RequestMapping("/deletecategory/{CategoryId}")
	public ModelAndView deletecategory(@PathVariable("CategoryId")String categoryId)
	{
	ModelAndView MV=new ModelAndView();
	category=categoryDao.getCategory(categoryId);
	if(categoryDao.delete(category)==true)
	{
	MV.addObject("Msg1","category deleted");
	}
	else
	{
	MV.addObject("Msg1","Category Not deleted");
	}
	MV.setViewName("redirect:/Category");
	return MV;
	}

}
