package com.victor.spring_security_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login"; // retorna -> login.html (templates/login.html) 
	}
	
	
	
}
