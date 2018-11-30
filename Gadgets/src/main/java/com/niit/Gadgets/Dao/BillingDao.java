package com.niit.Gadgets.Dao;

import java.util.List;

import com.niit.Gadgets.Model.Billing;

public interface BillingDao 
{

	public boolean saveorupdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String BillingId);
	public List<Billing> Billinglist();
	public Billing getUser(String userId);

	
	
	
}
