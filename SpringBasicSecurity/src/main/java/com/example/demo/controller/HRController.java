package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HRController {
	
	@GetMapping("/task")
	public String doHRWork()
	{
		
		return "search for employees , HR Work called ";
	}

}
