package com.mkj.app.service.hrservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkj.app.entity.Employee;
import com.mkj.app.entity.Project;
import com.mkj.app.repository.hrrepo.HREmployeeRepository;
import com.mkj.app.repository.hrrepo.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService
{

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	HREmployeeRepository empRepo;
	
	@Override
	public String createProject(Project project) {
		
		Project savedProject = proRepo.save(project);
	
		return "project Saved : code "+savedProject.getPcode();
	}

	
	@Override						//     pageNumber11 ,   10 pages
	public Page<Project> getAllProjects(int pageNumber,int size) 
	{
		Pageable pageable = PageRequest.of(pageNumber, size);
		Page<Project> tenPages = proRepo.findAll(pageable);
		                   // proRepo.findbyDesignation(designationName,pageableObj)
		return tenPages;
	}



	@Override
	public Project extractProjectByCode(int pcode) {
		return proRepo.findById(pcode).get();
	}

	@Override
	@Transactional
	public String linkEmployeeWithProject(int pcode, int empCode) {
		 
		Employee e = empRepo.findById(empCode).get();
		Project p = extractProjectByCode(pcode);
		  
		List<Employee> allWorkingEmployees = p.getAllEmployees() ; // internally exe SELECT Query
		  
		allWorkingEmployees.add(e); // exe update Query
		e.setProject(p);
		
		return e.getEmpName()+" "+e.getEmpCode()+" Linked with "+p.getProjectName();
		
	}

	
}//end class






















