package com.example.demo;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
//	@GetMapping("/courses")
//	public String abc() {
//		return "Hello world"; 
//	}
	
	@GetMapping("/courses")
	public List<Courses> getAllCourses(){
		return Arrays.asList(new Courses(1,"Learn Maths", "Amit"),
				new Courses(2,"Learn Angular", "Amit"));
				
	}
	
	@GetMapping("/courses/1")
	public Courses getSelectedCourseById(){
		return new Courses(1,"Learn Maths", "Amit");
				
				
	}

}
