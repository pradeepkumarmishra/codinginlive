package com.pradeep.spring.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pradeep.spring.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model){
		
		Student student=new Student();
		model.addAttribute("student", student);
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "show-form";
		}else{
		return "student-confirmation";
		}
	}

}
