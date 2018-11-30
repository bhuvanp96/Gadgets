package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.Supplier;

public interface SupplierDao 
{
	public boolean saveorupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSupplier(String SupplierId);
	public List<Supplier> Supplierlist();
}
