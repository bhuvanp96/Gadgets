package com.niit.Gadgets.Dao;

import java.util.List;


import com.niit.Gadgets.Model.Product;

public interface ProductDao 
{
	public boolean saveorupdate(Product product);
	public boolean delete(Product product);
	public Product getProduct(String ProductId);
	public List<Product> Productlist();
}
