package com.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public ResponseEntity<String> HelloWorld(String a) {
		a="hello world";
		return new ResponseEntity<String>(a,HttpStatus.OK);
	}
}
