package com.example.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String homePage() {
		return "This is home controller";
	}
	
	@GetMapping("/register")
	public String registrationPage() {
		return "This is registration Page";
	}
	
	@GetMapping("/contactUs")
	public String contactUsPage() {
		return "This is contactUs Page.";
	}
}
