package com.example.GradingService.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GradingService.controller.BaseController;
import com.example.GradingService.service.BaseService;

@RestController
@RequestMapping("")
public class BaseController {
	 Logger logger = LogManager.getLogger(BaseController.class);
	
	 
}
