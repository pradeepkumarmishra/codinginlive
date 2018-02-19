package com.pradeep.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping
	public String getMainPage(){
		return "main";
	}
	
	@RequestMapping("/form")
	public String getForms(){
		return "form";
	}
	
	@RequestMapping("/processForm")
	public String getProcessForms(@RequestParam("studentName") String name,Model model){
		
		//String name=request.getParameter("studentName");
		model.addAttribute("message",name);
		return "showDetails";
	}
	
	
}
