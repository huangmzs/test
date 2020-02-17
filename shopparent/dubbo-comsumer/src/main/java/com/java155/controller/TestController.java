package com.java155.controller;

import com.java155.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestService testService;

	@RequestMapping("/t1")
	public String t1(){
		return testService.index();
	}
}
