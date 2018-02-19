package com.pradeep.spring.mvc.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.groups.Default;

import com.pradeep.spring.mvc.customValidators.CourseCodeValidator;

@Constraint(validatedBy=CourseCodeValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	public String value() default "PRA";
	public String message() default "Value must start with PRA";
	// define default groups
		public Class<?>[] groups() default {};
		
		// define default payloads
		public Class<? extends Payload>[] payload() default {};

}
