package com.pocosoft.training.jobApplication.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pocosoft.training.jobApplication.engine.entities.JobRole;
import com.pocosoft.training.jobApplication.engine.repository.JobRoleRepository;

@SpringBootApplication
public class JobApplicationEngineApplication {
	@Autowired
	JobRoleRepository jobsRepo;

	public static void main(String[] args) {
		SpringApplication.run(JobApplicationEngineApplication.class, args);
	}
	@Bean
	CommandLineRunner runner()
	{
		return args ->
		{
			JobRole opening = new JobRole();
			
			opening.setDivision("ITD");
			opening.setUnit("System Integration Delivery");
			opening.setJobDescription("JAVA DEVELOPER");
			jobsRepo.save(opening);
		};
	}

}
