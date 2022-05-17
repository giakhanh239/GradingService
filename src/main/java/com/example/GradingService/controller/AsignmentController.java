package com.example.GradingService.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.response.Response;
import com.example.GradingService.service.AsignmentService;
import com.example.GradingService.service.StudentService;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping("asignment")
public class AsignmentController {
	@Autowired
	AsignmentService asignmentService;
	
	@PostMapping("/upload/db")
	public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file,@RequestParam("type") String type, @RequestParam("student_id") int id) {
		
		if(!asignmentService.checkTitleFormat(file)) {
			return new ResponseEntity<Response>(new Response("Wrong Format"),HttpStatus.PAYMENT_REQUIRED);
		};
		Asignment asignment = new Asignment();
		String fileName = file.getOriginalFilename();
		((Asignment) asignment).setTitle(fileName);
		try {
			asignment.setData(file.getBytes());
		} catch (IOException e) {
			return new ResponseEntity<Response>(new Response("Your File is Broken"),HttpStatus.PAYMENT_REQUIRED);
		}
		if(!asignmentService.saveAssignment(asignment,id)) {
			return new ResponseEntity<Response>(new Response("Can't Save File"),HttpStatus.PAYMENT_REQUIRED);
		}
		return ResponseEntity.ok(asignmentService.mergeStudentToAssignment(asignment, id));
	}
}
