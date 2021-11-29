package com.eManager.em.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eManager.em.model.Test_table;
import com.eManager.em.repository.TestRepository;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private TestRepository tstRepo;
	
	@GetMapping
	public String welcomeMesssage() {
		return "Welcome to eManager";
	}
	
	@GetMapping("/mc1")
	public String msg1() {
		return "This is test message2";
	}
	
	@GetMapping("/test1")
	public List<Test_table> getTestTable() {
		return tstRepo.findAll();
	}
}

