package com.niit.Gadgets.Dao;

import java.util.List;



import com.niit.Gadgets.Model.Category;

public interface CategoryDao 
{
public boolean saveorupdate(Category category);
public boolean delete(Category category);
public Category getCategory(String CategoryId);
public List<Category> Categorylist();




}
