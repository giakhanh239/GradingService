package com.example.GradingService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.GradingService.entity.Asignment;
@Service
public interface AsignmentService {
	boolean saveAssignment(Asignment asignment, int studentId);
	boolean checkTitleFormat(MultipartFile file);
	Asignment mergeStudentToAssignment(Asignment asignment, int studentId);
}
