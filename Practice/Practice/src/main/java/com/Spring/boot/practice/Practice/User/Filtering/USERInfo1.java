package com.Spring.boot.practice.Practice.User.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("userinfo1")
public class USERInfo1 {
	private int id;
	private String name;
	private String address;
	public USERInfo1(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	}

 