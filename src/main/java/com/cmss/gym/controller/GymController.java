package com.cmss.gym.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmss.gym.bean.GymBean;
import com.cmss.gym.bean.RegistrationBean;
import com.cmss.gym.service.gymservice;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
//@RequestMapping("/user")
public class GymController {
	//ObjectMapper mapper = new ObjectMapper();
	@Autowired 
	gymservice service;
	boolean res;
//	@RequestMapping(value="/")
//	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {  
//		System.out.println("-----------");
//		
//		
//		
//		String message = request.getParameter("gymName");  
//		return new ModelAndView("home", "msg", message);  
//	}  
	@RequestMapping(value="/enquiry",method = RequestMethod.POST)
	public ModelAndView enquiry(@RequestBody String payload,  HttpSession session, HttpServletRequest req) throws JsonProcessingException, IOException, JSONException {  
		System.out.println("--------------inside---enquiry---------"+payload);
		ModelAndView mav=new ModelAndView();
		//JsonNode c = mapper.readTree(payload);
		 Object obj=JSONValue.parse(payload);  
		 JSONObject jsonObject = (JSONObject) obj;  
		  String name = (String) jsonObject.get("name");  


		mav.addObject("uname", name);
		mav.addObject("Status", "200");

		

		return mav;
	}  
	
	@RequestMapping(value="/enquiryForm",method = RequestMethod.POST)
	public ModelAndView enquiryForm(@RequestBody String payload) throws JsonProcessingException, IOException, JSONException {  
		System.out.println("--------------inside---enquiryForm---------"+payload);
		 Object obj=JSONValue.parse(payload);  
		 JSONObject jsonObject = (JSONObject) obj;  
		  String name = (String) jsonObject.get("name");  
		  Long mobile = (Long) jsonObject.get("mobile");

		  System.out.println("name--"+name+"--mobile--"+mobile);
		return new ModelAndView("enquiry").addObject("resp","successful");
		
		//insert into DB code

		
	} 
	
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView Registration(@RequestBody String payload) {  
		System.out.println("--------------inside----Registration--------" + payload);

		//insert into DB code
		
        return new ModelAndView("registration");  
	}  
}
