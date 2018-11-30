package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.Cart;

public interface CartDao 
{

	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String Cart_Id);
	public List<Cart> Cartlist();

	
	
	
	
	
}
