package br.com.ksgprod.controller.request;

import java.io.Serializable;

import com.google.gson.Gson;

public class CustomerRequest implements Serializable {
	
	private static final long serialVersionUID = 3726834627715381642L;

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
