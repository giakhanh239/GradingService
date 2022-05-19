package com.example.GradingService.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.repository.AsignmentRepository;
import com.example.GradingService.response.Response;
import com.example.GradingService.service.AsignmentService;
import com.example.GradingService.service.NotificationService;
import com.example.GradingService.service.StudentService;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping("asignment")
public class AsignmentController {
	@Autowired
	AsignmentService asignmentService;
	@Autowired
	AsignmentRepository asignmentRepository;
	
	@PostMapping("/upload/db")
	public ResponseEntity uploadToDB(@Param("file") MultipartFile file,@RequestParam("type") String type, @RequestParam("student_id") int id, @Param("dataMultipleChoice") String dataMultipleChoice) {
		
		if(file!= null && !asignmentService.checkTitleFormat(file)) {
			return new ResponseEntity<Response>(new Response("Wrong Format"),HttpStatus.PAYMENT_REQUIRED);
		};
		Asignment asignment = new Asignment();
		if(file!=null){
			String fileName = file.getOriginalFilename();
			asignment.setTitle(fileName);
			
		}
		asignment.setStatus("Pending");
		asignment.setSubmitDate(java.time.LocalDateTime.now().toString());
		try {
			if(file != null)asignment.setData(file.getBytes());
			if(dataMultipleChoice!=null) asignment.setDataMultipleChoice(dataMultipleChoice);
			asignment.setType(type);
		} catch (IOException e) {
			return new ResponseEntity<Response>(new Response("Your File is Broken"),HttpStatus.PAYMENT_REQUIRED);
		}
		if(!asignmentService.saveAssignment(asignment,id)) {
			return new ResponseEntity<Response>(new Response("Can't Save File"),HttpStatus.PAYMENT_REQUIRED);
		}
		asignmentService.clasifyAssignment(asignment.getId());
		return ResponseEntity.ok(asignmentService.mergeStudentToAssignment(asignment, id));
	}

	@PostMapping("/mark/{id}")
	public ResponseEntity markManually(@PathVariable("id") int assignmentId, @RequestParam("score") double score) {
		boolean markSuccessfully = asignmentService.markAssignmentManually(assignmentId, score);
		if(markSuccessfully) {
			return ResponseEntity.ok(new Response("Mark Successfully!"));
		}
		return new ResponseEntity<Response>(new Response("Mark Failed!"),HttpStatus.PAYMENT_REQUIRED);
	}

}
