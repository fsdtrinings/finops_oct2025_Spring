package com.mkj.app.repository.hrrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mkj.app.dto.EmployeeDTO;
import com.mkj.app.dto.EmployeeProjectClientDTO;
import com.mkj.app.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> 
{

	/*
	 SQL Query
	 select e.emp_name,e.designation,p.project_name,p.client
	 from Employee e 
     Join project p on e.projectid = p.pcode;
	 
	 * */
	// 
	@Query(" select new com.mkj.app.dto.EmployeeProjectClientDTO "
			+ " (e.empName , e.designation , p.projectName,p.client) "
			+ " From Employee e "
			+ " Join e.project p ")
	
	public List<EmployeeProjectClientDTO> extractEmployeeLinkedWithProjectClientName();


	@Query(" select e.empName , e.designation , p.projectName,p.client "
			+ " From Employee e "
			+ " Join e.project p ")
	public List<EmployeeDTO> myQuery();


	@Query(value = "select e.emp_name,e.designation,p.project_name,p.client \r\n"
			+ "	 from Employee e \r\n"
			+ "  Join project p on e.projectid = p.pcode " ,
			nativeQuery = true)
	public List<EmployeeProjectClientDTO> mySQLNativeQuery();

}

















