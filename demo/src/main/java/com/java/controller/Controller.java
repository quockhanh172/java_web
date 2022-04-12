package com.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {
	
	@GetMapping("/hello")
	public ResponseEntity<String> HelloWorld(String a) {
		a="hello world";
		return new ResponseEntity<String>(a,HttpStatus.OK);
	}
}
