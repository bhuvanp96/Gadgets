package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.CartItems;

public interface CartItemsDao 

{
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(CartItems cartItems);
	public CartItems getCartItems(String Cartitem_Id);
	public List<CartItems> CartItemslist();
	public List<CartItems> getlist(String cart_Id);

}
