package com.niit.Gadgets.Dao;

import java.util.List;

import com.niit.Gadgets.Model.Pay;

public interface PayDao 
{
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String Pay_Id);
	public List<Pay> Paylist();

}
