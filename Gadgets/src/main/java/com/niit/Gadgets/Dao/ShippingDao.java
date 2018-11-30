package com.niit.Gadgets.Dao;

import java.util.List;

import com.niit.Gadgets.Model.Shipping;

public interface ShippingDao 
{

	
	public boolean saveorupdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping> Shippinglist();
	public List<Shipping> getaddbyuser(String userId);

	
	
	
}
