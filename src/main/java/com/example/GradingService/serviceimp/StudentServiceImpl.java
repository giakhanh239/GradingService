package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GradingService.entity.Student;
import com.example.GradingService.repository.StudentRepository;
import com.example.GradingService.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public boolean isStudentQualified(int studentId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student = studentRepository.getById(studentId);
		///
		if(student.getBaiTap() >0 && student.getChuyenCan() >0 && student.getThucHanh() >0 ) {
			return true;
			
		}
		return false;
	}

}
