package com.giz.security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/")
	public String helloWorld(){
		return "Hello World..!";
	} 
	
	@GetMapping("/report")
	public String generateReport() {
		return "Report is generated..!";
	}
	
	@GetMapping("/student")
	public String getStudents() {
		return "Students Retrieved..!";
	}

}
