package com.pocosoft.training.jobApplication.engine.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pocosoft.training.jobApplication.engine.entities.JobApplication;

public interface JobApplicationRepository extends PagingAndSortingRepository<JobApplication, Long> {

	@Override
	public List<JobApplication> findAll();
	
	
	public JobApplication findByApplicationId(long id);
	
}
