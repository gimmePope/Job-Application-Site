package com.pocosoft.training.jobApplication.engine.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.pocosoft.training.jobApplication.engine.validator.ValidPhoneNumber;

@Entity
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="application_seq")
	private long applicationId;
	@NotNull
	@NotBlank(message="Must give Full name")
	private String fullName;
	@Email
	private String email;
	@NotNull
	@ValidPhoneNumber(message="Please enter a valid phone number")
	private String phoneNumber;
	@NotNull
	private String jobDescription;
	@NotNull
	private String address;
	private String coverLetter;
	private String cv;
	
	

	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	public long getApplicationId() {
		return applicationId;
	}




	public void setApplicationId(long appliactionId) {
		this.applicationId = appliactionId;
	}




	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}




	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getCv() {
		return cv;
	}




	public void setCv(String cv) {
		this.cv = cv;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}


	
    	

}
