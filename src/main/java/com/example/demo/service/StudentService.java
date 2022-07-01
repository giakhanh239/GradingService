package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public interface StudentService{
	boolean isStudentQualified(int studentId);
	Student getStudentById(int studentId);
	void saveStudent(Student student);

}
