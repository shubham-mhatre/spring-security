package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.User;
import com.example.security.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserService userService;

	//getAll
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public User getUserById(@PathVariable("username") String username) {
		return userService.getUserByName(username);
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
