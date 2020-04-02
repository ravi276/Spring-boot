package com.Spring.boot.practice.Practice.User.UserResource;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class UserDao {
	static List<User> users=new ArrayList<User>();
	
static {
	users.add(new User(1,"Ravi","Bhandup",new Date()));
	users.add(new User(2,"Aditi","Sangli",new Date()));
	users.add(new User(3,"Monty","Airoli",new Date()));
	users.add(new User(4,"Gaurav","Dombivali",new Date()));
}

public List<User> getlist()
{
	return users;
	
}
public User saveUser(User user)
{
	System.out.println(user);
	users.add(user);
	return user;
}
public User getBId(int id)
{
	for(User user:users)
	{
		if(user.getId()==id)
			return user;
	}
	return null;
}
public User DeleteBId(int id)
{
	Iterator<User> itr=users.iterator();
    while(itr.hasNext())
    {
    User user=itr.next();	
	if(user.getId()==id)
	{
		itr.remove();
		return user;
	}
    }
	return null;
}
}
