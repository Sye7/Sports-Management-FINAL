package com.project.sports.event.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.model.Sports;
import com.project.sports.event.management.repository.SponsorRepository;
import com.project.sports.event.management.repository.SportRepository;

@Controller
@SessionAttributes("id")
public class SportsController {

	@Autowired
	SportRepository sportRepository;

	// Show Sports Registration Page
	@RequestMapping("/sportRegistration")
	public String showSportRegistration(@ModelAttribute("sports") Sports sports, ModelMap map, HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		sports = new Sports();
		return "sports";
	}

	// Sports Update Submission
	@RequestMapping(value = "/sportRegister", method = RequestMethod.GET)
	public String registerUser(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			ModelMap map) {
		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sports";
		}

		Sports temp = sportRepository.getSport(sports.getSportsId());
		if( temp != null && temp.getSportsId().equals(sports.getSportsId()))
		{
			map.addAttribute("failed", "This Id is already taken.");
			return "sports";
		}
		
		sportRepository.save(sports);
		map.put("successful", sports.getSportsName() + " is added successfully");

		return "organizerHome";
	}

	// Sports register Submission
	@RequestMapping(value = "/updateSportRegister", method = RequestMethod.GET)
	public String updateUser(@Valid @ModelAttribute("sports") Sports sports, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sportUpdate";
		}
		sportRepository.updateSport(sports.getNoOfPlayers(), sports.getTimeOfMatch(), sports.getSportsId());
		map.put("successful", sports.getSportsName() + " is updated successfully");
		return "organizerHome";
	}

	// Show Sport Update Page
	@RequestMapping("/updateSport")
	
	public String showUpdateForm(@ModelAttribute("sports") Sports sports, ModelMap map, HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		if (sports != null) {
			
			Sports spo = sportRepository.getOne(sports.getSportsId());
			map.put("sports", spo);
			return "sportUpdate";
		}
		return "SportsList";
	}

	@RequestMapping("/listsports")
	public String listform(@ModelAttribute("sports") Sports sports, ModelMap map, HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		List<Sports> li = sportRepository.findAll();
	
		List<String> lii = new ArrayList<>();
		for (Sports s : li) {
			lii.add(s.getSportsName());
		}
		map.put("li", li);

		return "SportsList";
	}

	
}
