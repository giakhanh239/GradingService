package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.GradingService.entity.Asignment;
import com.example.GradingService.service.AsignmentService;

@Service
public class AsignmentServiceImpl implements AsignmentService {


	@Override
	public double markAssignmentManually(Asignment asignment) {
		String[] Ans = {"a","b","c","d","e"};
		if(asignment.getType().equals("tl")){
			//Bài thi tự luận

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

			return score;
		}
		return 0;
	}

}
