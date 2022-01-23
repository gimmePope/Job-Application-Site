package com.pocosoft.training.jobApplication.engine.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
   String message() default "doesn't seem to be a valid phone number";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}
