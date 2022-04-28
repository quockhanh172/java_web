package com.java.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Student;

@RestController
@RequestMapping("api/v1/student")
public class HomeController {
	
	private static final List<Student> STUDENTS = Arrays.asList(
				new Student(1,"khanh","khanh123"),
				new Student(2,"Trang","trang123"),
				new Student(3,"vinh","vinh123")
			);
	
	@GetMapping(path="/{studentId}")
	public ResponseEntity<Student> HelloWorld(@PathVariable("studentId") int studentId) {
		Student student=STUDENTS.stream().filter(s->studentId==s.getId())
				.findFirst()
				.orElseThrow(()->new IllegalStateException("Student "+studentId+" not found"));
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
