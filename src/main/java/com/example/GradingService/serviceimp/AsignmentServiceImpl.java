package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.GradingService.service.AsignmentService;



@Service
public class AsignmentServiceImpl implements AsignmentService {
	String format = "B18DCCNXXXASYYZZZ.pdf";
	
	@Override
	public boolean checkTitleFormat(String filename) {
		if(filename.length() != format.length()) {
			return false;
		}
		if(filename.charAt(10) != 'A' || filename.charAt(11)!='S') {
			return false;
		}
		return true;
	}
}

