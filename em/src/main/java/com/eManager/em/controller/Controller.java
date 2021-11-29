package com.eManager.em.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
	
	@GetMapping
	public String welcomeMesssage() {
		return "Welcome to eManager";
	}
	
	@GetMapping("/mc1")
	public String msg1() {
		return "This is test message2";
	}
}
