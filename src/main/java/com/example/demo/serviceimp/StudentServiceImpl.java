package com.example.demo.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public boolean isStudentQualified(int studentId) {
		Student student = new Student();
		student = studentRepository.getById(studentId);
		///
		if(student.getBaiTap() >0 && student.getChuyenCan() >0 && student.getThucHanh() >0 ) {
			return true;
		}
		return false;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = new Student();
		student = studentRepository.getById(studentId);
		System.out.println(student.getId() + " " + student.getName());
		if(student.getId() != 0)
			return student;
		return null;
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	

}
