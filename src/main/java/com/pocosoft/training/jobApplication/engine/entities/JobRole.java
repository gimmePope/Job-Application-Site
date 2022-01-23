package com.pocosoft.training.jobApplication.engine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="job_seq")
	private long id;
	private String division;
	private String unit;
	private String jobDescription;
	
	public JobRole(String division, String unit, String jobDescription) {
		super();
		this.division = division;
		this.unit = unit;
		this.jobDescription = jobDescription;
	}

	public JobRole() {
		super();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		id = id;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	
	
	
	
	

}
