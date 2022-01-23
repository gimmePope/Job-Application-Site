package com.pocosoft.training.jobApplication.engine.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pocosoft.training.jobApplication.engine.entities.JobRole;

public interface JobRoleRepository extends PagingAndSortingRepository<JobRole, Long>  {
	
	@Override
	public List<JobRole> findAll();
	
	public void findById(long id);

}
