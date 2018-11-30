package com.niit.Gadgets.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication
{
	@Id
	private String  rId;
	private String  role_name="ROLE_USER";
	private String username;
	
	public Authentication()
	{
		this.rId="AUTH"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

	
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
