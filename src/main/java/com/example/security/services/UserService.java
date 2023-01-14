package com.example.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.security.models.User;

@Service
public class UserService {

	List<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User("abc","abc","abc@gmail.com"));
		userList.add(new User("xyz","xyz","xyz@gmail.com"));
		userList.add(new User("pqr","pqr","pqr@gmail.com"));		
	}
	
	//get All
	public List<User> getAllUsers(){
		return this.userList;
	}
	
	//get user by name
	public User getUserByName(String name) {
		return this.userList.stream()
				.filter(u->u.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}
	
	//add user
	public User addUser(User user) {
		this.userList.add(user);
		return user;
	}
	
}
