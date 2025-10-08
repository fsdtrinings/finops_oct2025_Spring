package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


	@GetMapping("/task")
	public String doSomeEmployeeWork()
	{
		return "doSome Employee Work called";
	}
	
}
