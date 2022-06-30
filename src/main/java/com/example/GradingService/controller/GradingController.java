package com.example.GradingService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.response.GradingResponse;
import com.example.GradingService.service.AsignmentService;


@RestController
@RequestMapping("mark")
public class GradingController {
	@Autowired
	AsignmentService asignmentService;

	@PostMapping("/assignment")
	public ResponseEntity markManually(@RequestBody Asignment asignment) {
		double score = asignmentService.markAssignmentManually(asignment);
		return new ResponseEntity<GradingResponse>(new GradingResponse("Complete Grading", score),HttpStatus.OK);
	}

}
