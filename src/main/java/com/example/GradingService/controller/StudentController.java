package com.example.GradingService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GradingService.response.Response;
import com.example.GradingService.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/studentQualify/{id}")
	public ResponseEntity<Response> checkStudentQualified(@PathVariable int id){
		boolean result = studentService.isStudentQualified(id);
		if(result) {
			return ResponseEntity.ok(new Response("Qualified"));
		}
		return new ResponseEntity<Response>(new Response("Not Qualified"),HttpStatus.PAYMENT_REQUIRED);
	}
}
