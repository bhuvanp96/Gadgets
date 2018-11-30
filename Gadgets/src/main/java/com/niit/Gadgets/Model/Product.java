package com.niit.Gadgets.Model;

import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product 
{
	
	
	@Transient
	private MultipartFile pimg;
	
	


	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}




	@Id
	private String ProductId;
	private String ProductName;
	private double ProductPrice;
	private String ProductQuantity;
	private String ProductDescription;
	
	public Product()
	{
		this.ProductId="PROD"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	
	
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="SupplierId")
	private Supplier supplier;
	
	
	
	
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		ProductQuantity = productQuantity;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	
	
	
	
	
	
}
