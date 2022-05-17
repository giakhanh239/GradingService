package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.entity.Student;
import com.example.GradingService.repository.AsignmentRepository;
import com.example.GradingService.repository.StudentRepository;
import com.example.GradingService.service.AsignmentService;

@Service
public class AsignmentServiceImpl implements AsignmentService {
	String format = "B18DCCNXXXASYYZZZ.pdf";
	@Autowired
	AsignmentRepository asignmentRepository;
	@Autowired
	StudentRepository studentRespository;
	@Override
	public boolean saveAssignment(Asignment asignment,int studentId) {
		try {
		Student student = new Student();
		student = studentRespository.findById(studentId).get();
		asignment.setStudent(student);
		asignmentRepository.save(asignment);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	@Override
	public boolean checkTitleFormat(MultipartFile file) {
		// TODO Auto-generated method stub
		Asignment asignment = new Asignment();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		if(fileName.length() != format.length()) {
			return false;
		}
		
		if(fileName.charAt(10) != 'A' || fileName.charAt(11)!='S') {
			return false;
		}
		
		// Add Ky thi ID
		
		return true;
	}



	@Override
	public Asignment mergeStudentToAssignment(Asignment asignment, int studentId) {
		asignment.setStudent(studentRespository.getById(studentId));
		return asignment;
	}
	

}
