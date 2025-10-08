package com.mkj.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectClientDTO {

	private String employeeName;
	private String designation;
	private String projectName;
	private String client;
	
	
}
