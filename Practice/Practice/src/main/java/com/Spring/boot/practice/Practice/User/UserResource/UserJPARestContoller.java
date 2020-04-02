package com.Spring.boot.practice.Practice.User.UserResource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPARestContoller {

	@Autowired
	UserRepository repo;
	@Autowired
	PostRepository prepo;
@GetMapping("/jpa/users")
public List<User> getAllUser()
{
	return repo.findAll();
}
@GetMapping("/jpa/users/{id}/post")
public List<Post> getAllMappedUser(@PathVariable int id)
{
	Optional<User> user=repo.findById(id);
	if(!user.isPresent())
	{
		throw new UserNotFound("id="+id+" Not Found");
	}
	return user.get().getPost();
}
@PostMapping("/jpa/users/{id}/post")
public ResponseEntity<User> saveUser1(@PathVariable int id,@RequestBody Post post)
{
	Optional<User> user1=repo.findById(id);
	if(!user1.isPresent())
	{
		throw new UserNotFound("id="+id+" Not Found");
	}
	User user=user1.get();
	post.setUser(user);
	prepo.save(post);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
	return ResponseEntity.created(location).build();
	
}
@GetMapping("/jpa/users/{id}")
 public Optional<User> getbyId(@PathVariable int id)
 {
	Optional<User> user=repo.findById(id);
	
	if(!user.isPresent())
	{
		throw new UserNotFound("id="+id+" Not Found");
	}
	return user;
 }
@PostMapping("/jpa/users")
public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
{
	
	repo.save(user);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
	return ResponseEntity.created(location).build();
	
}
@DeleteMapping("/jpa/users/{id}")
public void DeletebyId(@PathVariable int id)
{
	repo.deleteById(id);
}
}