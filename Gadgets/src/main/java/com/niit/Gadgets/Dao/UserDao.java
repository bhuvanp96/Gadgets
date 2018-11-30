package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.User;

public interface UserDao 
{
	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User getUser(String UserId);
	public List<User> Userlist();
	public User isValid(String umail, String pwd);
	public User getEmail(String currusername);
}
