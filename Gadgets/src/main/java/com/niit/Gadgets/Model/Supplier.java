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
public class Supplier
{
@Id
	private String SupplierId;
	private String SupplierName;
	private String SupplierAddress;
	private String SupplierPhno;
	private String SupplierEmailId;
	private String SupplierPassword;
	
	public Supplier()
	{
		this.SupplierId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	
	
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(String supplierId) {
		SupplierId = supplierId;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getSupplierAddress() {
		return SupplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		SupplierAddress = supplierAddress;
	}
	public String getSupplierPhno() {
		return SupplierPhno;
	}
	public void setSupplierPhno(String supplierPhno) {
		SupplierPhno = supplierPhno;
	}
	public String getSupplierEmailId() {
		return SupplierEmailId;
	}
	public void setSupplierEmailId(String supplierEmailId) {
		SupplierEmailId = supplierEmailId;
	}
	public String getSupplierPassword() {
		return SupplierPassword;
	}
	public void setSupplierPassword(String supplierPassword) {
		SupplierPassword = supplierPassword;
	}
	
	
}
