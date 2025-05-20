package com.victor.spring_security_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "Página pública";
	}
	
	@GetMapping("/dashboard")
	@ResponseBody
	public String dashboard() {
		return "Área protegida - Dashboard";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Área ADMIN: acesso autorizado!";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "Área USER: acesso autorizado!";
	}
	
	
	
	
}
