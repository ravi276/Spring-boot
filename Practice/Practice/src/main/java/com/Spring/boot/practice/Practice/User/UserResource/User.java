package com.Spring.boot.practice.Practice.User.UserResource;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2,message = "Name should have atleast 2 characters")
	private String name;
	private String Address;
	private Date DOB;
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	public User() {
		super();
	}
	public User(Integer id, String name, String address, Date DOB) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.DOB = DOB;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return Address;
	}
	public Date getDOB() {
		return DOB;
	}
	
	
	

}
