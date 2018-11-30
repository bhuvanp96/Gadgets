package com.niit.Gadgets.Model;

import java.util.List;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category 
{
	@Id
private String CategoryId;
private String CategoryName;

public Category()
{
	this.CategoryId="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

@OneToMany(mappedBy="category")
private List<Product> product;

public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public String getCategoryId() {
	return CategoryId;
}
public void setCategoryId(String categoryId) {
	CategoryId = categoryId;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}


}
