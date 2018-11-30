package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.Authentication;

public interface AuthenticationDao 
{

	public boolean saveorupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String rId);
	public List<Authentication> Authenticationlist();
}
