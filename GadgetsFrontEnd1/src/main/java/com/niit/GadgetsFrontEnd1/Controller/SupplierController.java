package com.niit.GadgetsFrontEnd1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/Supplier")
	public ModelAndView Supplierform()
	{
	ModelAndView MV=new ModelAndView();
	MV.addObject("Supplier",new Supplier());
	List<Supplier> supplierlist = supplierDao.Supplierlist();
	MV.addObject("Suppliers",supplierlist);
	MV.setViewName("Supplier");
	return MV ;
	}


	@RequestMapping("/addsupplier")
	public ModelAndView addsupplier(@ModelAttribute("Supplier")Supplier supplier)
	{
	ModelAndView MV=new ModelAndView();
	if(supplierDao.saveorupdate(supplier)==true)
	{
	MV.addObject("Msg","Supplier saved");
	}
	else
	{
	MV.addObject("Msg","Supplier Not saved");
	}
	MV.setViewName("redirect:/Supplier");
	return MV;
	}


	@RequestMapping("/editsupplier/{SupplierId}")
	public ModelAndView editsupplier(@PathVariable("SupplierId")String SupplierId)
	{ 
	ModelAndView MV=new ModelAndView("Supplier");
	supplier=supplierDao.getSupplier(SupplierId);
	MV.addObject("Supplier",supplier);
	List<Supplier> supplierlist = supplierDao.Supplierlist();
	MV.addObject("Suppliers",supplierlist);
	return MV;
	}


	@RequestMapping("/deletesupplier/{SupplierId}")
	public ModelAndView deletesupplier(@PathVariable("SupplierId")String supplierId)
	{
	ModelAndView MV=new ModelAndView();
	supplier=supplierDao.getSupplier(supplierId);
	if(supplierDao.delete(supplier)==true)
	{
	MV.addObject("Msg1","Supplier deleted");
	}
	else
	{
	MV.addObject("Msg1","Supplier Not deleted");
	}
	MV.setViewName("redirect:/Supplier");
	return MV;
	}

}
