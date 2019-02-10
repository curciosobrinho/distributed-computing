package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class rootController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pageTitle", ".:: My Mugs ::.");
		return "home";
	}

	@RequestMapping(path = "/contactus", method = RequestMethod.GET)
	public String viewContactUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pageTitle", ".:: Contact Us ::.");
		return "ContactUs";
	}
	
	@RequestMapping(path = "/aboutus", method = RequestMethod.GET)
	public String viewAbouttUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pageTitle", ".:: About Us ::.");
		return "AboutUs";
	}
}
