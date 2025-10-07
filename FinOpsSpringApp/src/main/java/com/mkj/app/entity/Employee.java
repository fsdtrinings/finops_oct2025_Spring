package com.mkj.app.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Schema(description = "Details about the Employee class in the system")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Employee code , Unique identification of an employee")
	private int empCode;
	
	@NotBlank(message = "Employee name cannot be blank")
	@Size(min = 2,max = 30 , message = "name should be 2 to 50 char long")
	private String empName;
	
	@Schema(description = "Value [java , SFDC , AWS]")
	@Size(min = 5,max = 30 , message = "techname should be 2 to 50 char long")
	private String techName;
	
	@Schema(description = "Value [developer , associate , consultant, Project Manager]")
	@NotBlank(message = "Designation cannot be blank")
	@Size(min = 5,max = 30 , message = "designation name should be 2 to 50 char long")
	private String designation;
	
	@Min(value = 1000, message = "Salary must be more than 1000")
    @Max(value = 15000, message = "Salary cannot be more than 15000")
	private int salary;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "docid")
	private KYCDocuments empDocs;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "profileId")
	private Profile profile;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="projectid")
	private Project project;
}














