package com.cmss.gym.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmss.gym.bean.RegistrationBean;

@Controller
public class RegistrationController {

/*	@RequestMapping(value="/Registration",method = RequestMethod.POST)
	 public ModelAndView enquiry(@ModelAttribute("RegistrationForm") RegistrationBean bean,HttpServletRequest request,HttpServletResponse response) {  
		System.out.println("--------------inside----Registration--------");
      //String username = request.getParameter("username");  
      //String mobile = request.getParameter("mobile"); 
      System.out.println("----name--"+bean.getFees()+"--- mobile---"+bean.getMobile());
      
      
      return new ModelAndView("index", "msg", bean);  
  }  */	
}
