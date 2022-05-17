package com.example.GradingService.service;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
	boolean isStudentQualified(int studentId);
}
