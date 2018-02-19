package com.pradeep.spring.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.pradeep.spring.mvc.interfaces.CourseCode;

public class Student {

	public Student() {
		languageOptions.put("C", "c");
		languageOptions.put("java", "java");
		languageOptions.put("C#", "c#");
	}

	
	@Size(min=1,message="Field is required")
	private String firstName;
	
	@NonNull
	private String lastName;
	
	private String country;
	private String language;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}",message="Please enter valid postal code of 5 chars")
	private String postalCode;
	

	@Min(value=1)
	@Max(value=10,message="Value must be less than 10")
	private Integer freePasses;
	
	//custom validation
	@CourseCode(value="PRA",message="Course code should start with PRA")
	private String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public Integer getFreePasses() {
		return freePasses;
	}


	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}


	public String getPostalCode() {
		return postalCode;
	}
    
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private LinkedHashMap<String, String> languageOptions = new LinkedHashMap<>();

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
