package com.pocosoft.training.jobApplication.engine.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pocosoft.training.jobApplication.engine.entities.JobApplication;
import com.pocosoft.training.jobApplication.engine.entities.JobRole;
import com.pocosoft.training.jobApplication.engine.repository.JobApplicationRepository;
import com.pocosoft.training.jobApplication.engine.repository.JobRoleRepository;

@Controller
public class JobApplicationController {
	
	@Autowired
	JobRoleRepository jobsRepo;
	@Autowired
	JobApplicationRepository applicationRepo;
	@Value("${app.cv.storage.location}")
	String cvStore;
	private static final Logger LOGGER= LoggerFactory.getLogger(JobApplicationController.class);
			
	
	@GetMapping("/view/application")
	public String displayApplicationForm(Model model)
	{
		JobApplication application = new JobApplication();
		List<JobRole> vacancies = jobsRepo.findAll();
		
		model.addAttribute("newApplication", application);
		model.addAttribute("openings", vacancies);
		return "apply";
	}
	
	@PostMapping("/process/jobApplication")
	public String  processApplication(@ModelAttribute("newApplication") @Valid JobApplication application,Errors errors , @RequestParam("file_cv") MultipartFile file ,RedirectAttributes redirectAttributes, Model model)
	{
		if(errors.hasErrors())
		{
			LOGGER.error("Number of errors found: "+ errors.getErrorCount());
			List<JobRole> vacancies = jobsRepo.findAll();
			model.addAttribute("newApplication", application);
			model.addAttribute("openings", vacancies);
			return "apply";
		}
		LOGGER.info(application.getFullName() + ", your application is processing");
		
		if (file.isEmpty()) {
			LOGGER.info("No file found!!!!!!!!!!!!!!!!!!!!!");
		}
		else
		{
			LOGGER.info("File found, file name: " + file.getOriginalFilename());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			LOGGER.info("extension: " + extension);
			String suffix = formatter.format(new Date());
			File toBeUploaded = new File(cvStore + application.getFullName().replace(" ", "") + suffix+extension);
			LOGGER.info("File to be created: " + toBeUploaded.getPath());
			boolean fileCreated = false;
			try {
				fileCreated = toBeUploaded.createNewFile();
				if(fileCreated)
				{
					
					FileOutputStream fout = new FileOutputStream(toBeUploaded);
					fout.write(file.getBytes());
					fout.close();
					LOGGER.info("file upload complete and successful");
					application.setCv(toBeUploaded.getPath());
					JobApplication created = applicationRepo.save(application);
					redirectAttributes.addFlashAttribute("message", "Application Received, We will  revert in the shortest possible time");
		            return "redirect:/status";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		redirectAttributes.addFlashAttribute("message", "Application Failed");
        return "redirect:/status";
	}
	
	
	@GetMapping("/status")
	public String displayApplicationStatus()
	{
		return "status";
	}

}
