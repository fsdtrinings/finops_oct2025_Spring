package com.mkj.app.service.hrservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mkj.app.dto.EmployeeDTO;
import com.mkj.app.dto.EmployeeProjectClientDTO;
import com.mkj.app.entity.Project;

@Service
public interface ProjectService {

	public String createProject(Project project);
	public Page<Project> getAllProjects(int pageNumber,int size); 
	public Project extractProjectByCode(int pcode);
	public String linkEmployeeWithProject(int pcode,int empCode);
	
	
	// ---- @Query operations ---
	public List<EmployeeProjectClientDTO> extractEmployeeLinkedWithProjectClientName();
	public List<EmployeeProjectClientDTO> doThings();
}
