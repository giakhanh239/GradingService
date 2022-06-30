package com.example.GradingService.service;

import org.springframework.stereotype.Service;

@Service
public interface AsignmentService {
	boolean checkTitleFormat(String filename);
}