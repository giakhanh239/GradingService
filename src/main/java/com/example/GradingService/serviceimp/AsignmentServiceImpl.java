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
import com.example.GradingService.service.NotificationService;

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
	

	@Override
	public boolean markAssignmentManually(int asignmentId, double score) {
		Asignment asignment = new Asignment();
		asignment = asignmentRepository.findById(asignmentId).get();
		
		int studentId = asignment.getStudent().getId();
		Student student = new Student();
		student = studentRespository.findById(studentId).get();
		student.setCuoiKy(score);

		studentRespository.save(student);
		NotificationService.sendNotification("Sinh viên: @" + student.getName() + " - MSV: " + studentId + " đã hoàn thành bài thi! Kết quả: " + score + " điểm" );
		return true;
	}



	@Override
	public void clasifyAssignment(int asignmentId) {
		String[] Ans = {"a","b","c","d","e"};
		Asignment asignment = new Asignment();
		asignment = asignmentRepository.findById(asignmentId).get();
		if(asignment.getType().equals("tl")){
			asignment.setStatus("pending");
			// asignmentRepository.save(asignment);
			NotificationService.sendNotification("Bài thi của sinh viên @" + asignment.getStudent().getName() + " đang trong quá trình chấm điểm");
		} else{ //Bài thi trắc nghiệm
			double score = 0.0;
			String result = asignment.getDataMultipleChoice();
			String[] arr1 = result.split(";");
			for(String i: arr1){
				String[] arr2 = i.split("-");
				if(Ans[Integer.parseInt(arr2[0])-1].equals(arr2[1])){
					score += 2;
				}
			}

			markAssignmentManually(asignmentId, score);
		}
	}


}
