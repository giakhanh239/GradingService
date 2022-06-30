package com.example.GradingService.service;

import org.springframework.stereotype.Service;

import com.example.GradingService.entity.Asignment;
@Service
public interface AsignmentService {
	double markAssignmentManually(Asignment asignment);
}
