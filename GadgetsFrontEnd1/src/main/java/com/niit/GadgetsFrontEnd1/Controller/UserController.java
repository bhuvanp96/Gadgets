package com.niit.GadgetsFrontEnd1.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.User;
import com.niit.Gadgets.Dao.UserDao;


@Controller
public class UserController
{
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/User")
	public ModelAndView Userform()
	{
	ModelAndView MV=new ModelAndView();
	MV.addObject("user",new User());
	List<User> catList = userDao.Userlist();
	MV.addObject("users",catList);
	MV.setViewName("index");
	return MV ;
	}

	@RequestMapping("/adduser")
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{
	ModelAndView MV=new ModelAndView();
	Cart cart= new Cart();
	
	user.setCart(cart);
	if(userDao.saveorupdate(user)==true)
	{
	MV.addObject("Msg","User saved");
	}
	else
	{
	MV.addObject("Msg","User Not saved");
	}
	MV.setViewName("redirect:/User");
	return MV;
	}
	
	
	
}
