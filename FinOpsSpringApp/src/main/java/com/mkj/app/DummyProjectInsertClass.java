package com.mkj.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mkj.app.entity.Project;
import com.mkj.app.repository.hrrepo.ProjectRepository;

/**
 *  inserting dummy project s : count 300
 *  * **/

//@Component
public class DummyProjectInsertClass implements CommandLineRunner 
{
	@Autowired
	ProjectRepository projectRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		System.err.println("Insert Dummy Records");
		int i=0;
		for(;i<300;i++)
		{
			Project p = new Project("Project-"+(i+1),"Client Name -"+(i+1));
			
			projectRepo.save(p);
			
		}
		
		System.err.println("Added Records "+i);

	}
	
}//end class
