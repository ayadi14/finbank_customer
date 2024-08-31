package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Demo {
	
	
	@GetMapping("para")
	public String getMethodName() {
		return "shan";
	}
	

}
