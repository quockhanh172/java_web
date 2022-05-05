package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Student;
import com.java.security.ApplicatitonUserRole;

@RestController
@RequestMapping("managerment/api/v1/students")
public class StudentManagerController {

	private static final List<Student> STUDENTS = Arrays.asList(
				new Student(1,"khanh","khanh123"),
				new Student(2,"Trang","trang123"),
				new Student(3,"vinh","vinh123")
			);
	@GetMapping
	public List<Student> getAllStudent(){
		return STUDENTS;
	}
	
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		System.out.print(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		System.out.print(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student) {
		System.out.print(String.format("%s %s", student,studentId));
	}
}
