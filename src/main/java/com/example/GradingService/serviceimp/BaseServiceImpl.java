package com.example.GradingService.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.GradingService.repository.BaseRepository;
import com.example.GradingService.service.BaseService;

public class BaseServiceImpl implements BaseService {
	@Autowired 
	BaseRepository baseRepository;
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
