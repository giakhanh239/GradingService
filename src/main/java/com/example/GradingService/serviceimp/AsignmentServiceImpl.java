package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.repository.AsignmentRepository;
import com.example.GradingService.service.AsignmentService;

@Service
public class AsignmentServiceImpl implements AsignmentService {
	@Autowired
	AsignmentRepository asignmentRepository;

}
