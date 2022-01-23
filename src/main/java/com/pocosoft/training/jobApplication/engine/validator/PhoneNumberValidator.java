package com.pocosoft.training.jobApplication.engine.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String>{

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

       if(value.startsWith("+234"))
       {
    	  String uniqueDigits= value.replace("+234", "");
    	  
    	  if(uniqueDigits.length() != 10)
    	  {
    		  return false;
    	  }
    	  else
    	  {
    		  String patternString = "^[0-9]+$";
    		  Pattern pattern = Pattern.compile(patternString);

    	        Matcher matcher = pattern.matcher(uniqueDigits);
    	        boolean matches = matcher.matches();
    		  return matches;
    	  }
    	  
    	  
       }
       else
       {
    	   return false;
       }
		
	}
	
	

}
