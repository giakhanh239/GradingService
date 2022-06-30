
package com.example.GradingService.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GradingService.model.Response;
import com.example.GradingService.service.AsignmentService;

@RestController
@RequestMapping("verify")
public class VerifyController {
	@Autowired
	AsignmentService asignmentService;
	@PostMapping("/check")
	public ResponseEntity uploadToDB(@Param("file") String filename) {
		
		if(filename!= null && !asignmentService.checkTitleFormat(filename)) {
			return new ResponseEntity<Response>(new Response("Wrong Format"),HttpStatus.PAYMENT_REQUIRED);
		}
		else return new ResponseEntity<Response>(new Response("Correct Format"),HttpStatus.OK);
		}
}
