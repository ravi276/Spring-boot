package com.Spring.boot.practice.Practice.User.UserResource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRestContoller {
	@Autowired
	UserDao dao;
@GetMapping("/users")
public List<User> getAllUser()
{
	return dao.getlist();
}
@GetMapping("/users/{id}")
 public User getbyId(@PathVariable int id)
 {
	User user=dao.getBId(id);
	if(user==null)
	{
		throw new UserNotFound("id="+id+" Not Found");
	}
	return user;
 }
@PostMapping("/users")
public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
{
	
	dao.saveUser(user);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
	return ResponseEntity.created(location).build();
	
}
@DeleteMapping("/users/{id}")
public void DeletebyId(@PathVariable int id)
{
	User user=dao.DeleteBId(id);
	if(user==null)
	{
		throw new UserNotFound("id="+id+" Not Found");
	}
}
}