package com.java155.shop.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@Controller
public class PageController {

	@RequestMapping("/${path}.jhtml")
	public String toPage(@PathVariable String path){
		return path;
	}

	@RequestMapping("/${toPath}.html")
	public String toFreemarkerPage(@PathVariable String toPath){

		return toPath;
	}

}
