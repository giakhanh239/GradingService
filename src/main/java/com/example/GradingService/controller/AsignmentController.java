package com.example.GradingService.controller;

import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;
// import java.util.Calendar;
import java.util.List;

// import javax.swing.event.DocumentListener;
// import javax.swing.event.UndoableEditListener;
// import javax.swing.text.AttributeSet;
// import javax.swing.text.BadLocationException;
// import javax.swing.text.Document;
// import javax.swing.text.Element;
// import javax.swing.text.Position;
// import javax.swing.text.Segment;
// import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.repository.AsignmentRepository;
// import com.example.GradingService.response.Response;
import com.example.GradingService.service.AsignmentService;
// import com.pengrad.telegrambot.model.ResponseParameters;

// import okhttp3.ResponseBody;

// import org.springframework.util.StringUtils;

@RestController
@RequestMapping("asignment")
public class AsignmentController {
	@Autowired
	AsignmentService asignmentService;
	@Autowired
	AsignmentRepository asignmentRepository;

	@PostMapping("/createAssignment")
	public ResponseEntity createAssignment(
		@Param("status") String status,
		@Param("type") String type,
		@Param("file") MultipartFile file,
		@Param("student_id") int studentId, 
		@Param("dataMultipleChoice") String dataMultipleChoice){
			Asignment asignment = new Asignment();
			asignment.setStatus(status);
			asignment.setType(type);
			asignment.setTitle(file.getOriginalFilename());
			try {
				asignment.setData(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			asignment.setDataMultipleChoice(dataMultipleChoice);
			asignment.setSubmitDate(java.time.LocalDateTime.now().toString());
			asignment.setStudentId(studentId);
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
