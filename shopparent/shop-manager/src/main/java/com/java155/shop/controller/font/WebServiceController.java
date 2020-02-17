package com.java155.shop.controller.font;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {

	@RequestMapping("/t1.ws")
	public String t1(){
		return "first webService";
	}
}
