package com.project.sports.event.management.controller;

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
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.model.Report;
import com.project.sports.event.management.model.Sports;
import com.project.sports.event.management.repository.EventRepository;

@Controller
@SessionAttributes("id")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	// Show Event Registration Page
	@RequestMapping("/eventRegistration")
	public String showEventRegistration(@ModelAttribute("event") Event event, HttpSession session, ModelMap map) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		event = new Event();
		return "eventRegisPage";
	}

	// Event Registration Submission
	
	@RequestMapping(value = "/eventRegister", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "eventRegisPage";
		}
		
		Event temp = eventRepository.getEvent(event.getEventId());
		if( temp != null && temp.getEventId().equals(event.getEventId()))
		{
			map.addAttribute("failed", "This Id is already taken.");
			return "eventRegisPage";
		}

		eventRepository.save(event);
		map.put("successful", event.getEventName()+ " event is successfully Created");
	
		return "organizerHome";
	}
	
	
	
	  // Show Event Update Page
		@RequestMapping("/updateEvent")
		public String showUpdateForm(@ModelAttribute("event") Event event, ModelMap map, HttpSession session ) {
			
			Credentials credentials = (Credentials) session.getAttribute("id");
			if(credentials == null)
			{
				map.addAttribute("session", "Your Session is Expired please Login Again..");
				return "forward:/home";
			}
			
			Event evt =   eventRepository.getOne(event.getEventId());
			map.put("event", evt);
			return "updateEvent";
		}

		
		@RequestMapping("/listEvent")
		public String listEvent(@ModelAttribute("event") Event event,ModelMap m, HttpSession session ) {
			
			Credentials credentials = (Credentials) session.getAttribute("id");
			if(credentials == null)
			{
				m.addAttribute("session", "Your Session is Expired please Login Again..");
				return "forward:/home";
			}
			
			List<Event> li = eventRepository.findAll();
			m.put("li", li);
			return "eventList";
		}

			
		// Event Update Submission
		
		@RequestMapping(value = "/updateEventF", method = RequestMethod.POST)
		public String registerEvent(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult,
				ModelMap map) {

			if (bindingResult.hasErrors()) {
				System.out.println("ui details not correct");
				return "updateEvent";
			}

			eventRepository.updateEvent(event.getEventId(), event.getDate(), event.getTime(), event.getVenue(), event.getNoOfSlots());
			map.put("successful", event.getEventName()+ " event is successfully Updated");
		
			return "organizerHome";
		}
		
		@RequestMapping("/listEventD")
		public String listEventForDelete(@ModelAttribute("event") Event event,ModelMap m, HttpSession session ) {
			
			Credentials credentials = (Credentials) session.getAttribute("id");
			if(credentials == null)
			{
				m.addAttribute("session", "Your Session is Expired please Login Again..");
				return "forward:/home";
			}
			
			List<Event> li = eventRepository.findAll();
			m.put("li", li);
			return "listeventdelete";
		}
		
		
		// Delete Event
		@RequestMapping("/deleteEvent")
		public String deleteEvent(@ModelAttribute("event") Event event, ModelMap map ) {
			
			Event temp = eventRepository.getOne(event.getEventId());
			map.put("successful", temp.getEventName()+ " event is successfully Cancelled");
			eventRepository.deleteEvent(event.getEventId());
			
			return "organizerHome";
		}

		
		
		
		@RequestMapping("/listEventReport")
		public String FinalEventReport(@ModelAttribute("report") Report event,ModelMap m, HttpSession session ) {
			
			Credentials credentials = (Credentials) session.getAttribute("id");
			if(credentials == null)
			{
				m.addAttribute("session", "Your Session is Expired please Login Again..");
				return "forward:/home";
			}
			
			List<Event> e =  eventRepository.findAll();
			m.put("eve",e);
			
			return "eventreport";
		}
		
		

}
