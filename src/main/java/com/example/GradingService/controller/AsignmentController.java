package com.example.GradingService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.repository.AsignmentRepository;
import com.example.GradingService.service.AsignmentService;

@RestController
@RequestMapping("asignment")
public class AsignmentController {
	@Autowired
	AsignmentService asignmentService;
	@Autowired
	AsignmentRepository asignmentRepository;

	@PostMapping("/createAsignment")
	public ResponseEntity createAssignment(@RequestBody Asignment asignment){
			asignmentRepository.save(asignment);
			return ResponseEntity.ok(asignment);
	}

	@GetMapping("/getAllAssignment")
	public List<Asignment> getAsignment(@RequestParam("student_id") int studentId){
		return asignmentRepository.findAll();
	}

	@PutMapping("/updateAssignment")
	public ResponseEntity updateAsignment(@RequestBody Asignment asignment){
		asignmentRepository.save(asignment);
		return ResponseEntity.ok(asignment) ;
	}

	@DeleteMapping("/deleteAssignment")
	public ResponseEntity deleteAsignment(@RequestBody Asignment asignment){
		asignmentRepository.delete(asignment);
		return ResponseEntity.ok("Delete Success");
	}

}
