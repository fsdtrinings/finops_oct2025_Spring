package com.mkj.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.dto.EmployeeDTO;
import com.mkj.app.dto.EmployeeProjectClientDTO;
import com.mkj.app.entity.Project;
import com.mkj.app.service.hrservice.ProjectService;



@RestController
@RequestMapping("/pm")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	public ProjectController() {
		System.out.println("Project controller constructor");
	}

	
	@PostMapping("/project")
	public String saveProject(@RequestBody Project p)
	{
		System.out.println("-->> Project create : "+p);
		return projectService.createProject(p);
	}
	
	// localhost:8085/pm/projects?page=1&size=10
	@GetMapping("/projects")
	public ResponseEntity<Page<Project>> getAllProjects(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size
			)
	{
		Page<Project>  allPageRecords = projectService.getAllProjects(page, size);
		return new ResponseEntity<Page<Project>>(allPageRecords,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/project/{code}")
	public Project getProjectbyCode(@PathVariable int code)
	{
		
		return projectService.extractProjectByCode(code);
	}
	
	
	@PutMapping("/project/link")
	public String linkEmployeeWithProject(@RequestParam int pcode,
										@RequestParam int ecode)
	{
		
		String msg = projectService.linkEmployeeWithProject(pcode, ecode);
		
		return msg;
	}
	
	
	//  /pm/objects
	@GetMapping("/dto1")
	public List<EmployeeProjectClientDTO> getEmployeeProjectdata()
	{
		
	List<EmployeeProjectClientDTO>	list = projectService.extractEmployeeLinkedWithProjectClientName();
		return list;
	}
	
	
	@GetMapping("/dto2")
	public List<EmployeeProjectClientDTO> getEmployeeProjectdata2()
	{
		
	List<EmployeeProjectClientDTO>	list = projectService.doThings();
		return list;
	}
	
	
	
	
}//end class







































