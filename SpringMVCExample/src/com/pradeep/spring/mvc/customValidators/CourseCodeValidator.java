package com.pradeep.spring.mvc.customValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pradeep.spring.model.Student;
import com.pradeep.spring.mvc.interfaces.CourseCode;

public class CourseCodeValidator implements ConstraintValidator<CourseCode,String >{

	private String codePrefix;
	@Override
	public void initialize(CourseCode courseCode) {
		// TODO Auto-generated method stub
		
		this.codePrefix=courseCode.value();
	}
	@Override
	public boolean isValid(String courseCodeValue, ConstraintValidatorContext thrConstraintValidatorContext) {
		// TODO Auto-generated method stub
		System.out.println("courseCodeValue"+courseCodeValue);
		if(courseCodeValue.startsWith(codePrefix)){
		return true;
		
		}
		return false;
	}

}
