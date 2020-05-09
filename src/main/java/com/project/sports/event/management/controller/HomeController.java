package com.project.sports.event.management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String getHomePage(HttpSession session) {
		session.invalidate();
		return "home";
	}

}
