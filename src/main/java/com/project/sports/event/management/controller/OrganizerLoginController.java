package com.project.sports.event.management.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Coach;
import com.project.sports.event.management.model.CoachRegis;
import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.NotificationCoach;
import com.project.sports.event.management.model.NotificationSponsor;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.model.SponsorRegis;
import com.project.sports.event.management.repository.CoachReqRepos;
import com.project.sports.event.management.repository.EventRepository;
import com.project.sports.event.management.repository.NotificationCoachRepos;
import com.project.sports.event.management.repository.NotificationSponsorRepos;
import com.project.sports.event.management.repository.OrganizerRepository;
import com.project.sports.event.management.repository.SponsorReqRepos;

@Controller
@SessionAttributes({ "sponsorList", "coachList","id" })
public class OrganizerLoginController {

	@Autowired
	OrganizerRepository organizerRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	SponsorReqRepos sponsorReqRepos;

	@Autowired
	CoachReqRepos coachReqRepos;

	@Autowired
	NotificationSponsorRepos notificationSponsorRepos;

	@Autowired
	NotificationCoachRepos notificationCoachRepos;



	// Organizer Login page
	@RequestMapping(value = "/organizerLogin", method = RequestMethod.GET)
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		credentials = new Credentials();
		return "organizerLogin";
	}

	// Organizer Login Validation page

	@RequestMapping(value = "/orgSub", method = RequestMethod.POST)
	public String validateOrganizerRegistration(@ModelAttribute("credentials") Credentials credentials,
			HttpSession session, ModelMap map) {
		Organizer org = organizerRepository.getOrganizer(credentials.getId(), credentials.getPassword());

		if (org != null) {
			session.setAttribute("id", credentials);
			map.put("credentials", credentials);
			
		List<SponsorRegis> sponsorRegis	=sponsorReqRepos.findAll();
		int sizeSponsor=sponsorRegis.size();
	    List<CoachRegis> coachRegis=coachReqRepos.findAll();
	    int sizeCoach=coachRegis.size();
		map.put("sizeSponsor",sizeSponsor);
		map.put("sizeCoach",sizeCoach);
			return "organizerHome";
		}

		map.addAttribute("failed", "Credentials does not matched");
		return "organizerLogin";

	}

	// Show organizer Registration Page
	@RequestMapping("/organizerRegistration")
	public String showOrganizerRegistration(@ModelAttribute("organizer") Organizer organizer) {
		organizer = new Organizer();
		return "organizerRegisPage";
	}

	// Organizer Registration Submission

	@RequestMapping(value = "/organizerRegisterUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("organizer") Organizer organizer, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "organizerRegisPage";
		}
		
		Optional<Organizer> organizerExists = organizerRepository.findById(organizer.getOrganizerId());
		
		if ( organizerExists.isPresent()) 
		{
			Organizer temp = organizerExists.get();
			
			if(temp.getOrganizerId().equals(organizer.getOrganizerId()))
			{
			map.addAttribute("failed", "This Id is already taken.");
			return "organizerRegisPage";
		}
	}

		organizerRepository.save(organizer);
		map.put("successful", organizer.getFirstName() + " your details are submitted successfully");
		map.addAttribute("credentials", new Credentials());
		return "organizerLogin";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@RequestMapping("/sponsorRequests")
	public String sponsorRequests(@ModelAttribute("sponsorregis") SponsorRegis sponsorRegis, ModelMap m,
			HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			m.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		List<SponsorRegis> sponsorList = sponsorReqRepos.findAll();
	    List<CoachRegis> coachRegis=coachReqRepos.findAll();
	    int sizeCoach=coachRegis.size();
		m.put("sizeCoach",sizeCoach);
		m.addAttribute("sponsorList", sponsorList);

		return "sponsorRequest";
	}

	@RequestMapping("/sponsorAcpt")
	public String hello(ModelMap map, HttpServletRequest req, HttpSession session) {
		String sponsorReq = (String) req.getParameter("EventRegistration");

		String notify[] = sponsorReq.split(":");

		String eventId = notify[0];
		String sponsorId = notify[1];

		String status = "Approved";
		String request = "";

		Event temp = eventRepository.getOne(eventId);
		SponsorRegis sponsortemp = sponsorReqRepos.getSponsorRequest(eventId, sponsorId);

		NotificationSponsor notification = new NotificationSponsor(temp.getEventId(), temp.getEventName(),
				temp.getDate(), temp.getVenue(), sponsortemp.getSponsorId(), sponsortemp.getSponsorName(), status);

		notificationSponsorRepos.save(notification);

		sponsorReqRepos.deleteById(eventId);

		map.put("req", request + " request is Accepted Successfully");

	
		return "redirect:/sponsorRequests";
	}

	@RequestMapping("/sponsorReject")
	public String hellodelete(ModelMap map, HttpServletRequest req, HttpSession session) {

		String coachReq = (String) req.getParameter("EventRegistration");

		String notify[] = coachReq.split(":");

		String eventId = notify[0];
		String sponsorId = notify[1];

		String status = "Reject";
		String request = "";

		Event temp = eventRepository.getOne(eventId);
		SponsorRegis sponsortemp = sponsorReqRepos.getSponsorRequest(eventId, sponsorId);

		NotificationSponsor notification = new NotificationSponsor(temp.getEventId(), temp.getEventName(),
				temp.getDate(), temp.getVenue(), sponsortemp.getSponsorId(), sponsortemp.getSponsorName(), status);

		notificationSponsorRepos.save(notification);

		sponsorReqRepos.deleteById(eventId);

		map.put("req", request + " request is Accepted Successfully");
		return "redirect:/sponsorRequests";

	}

	@RequestMapping("/coachRequests")
	public String listRequest(@ModelAttribute("coachregis") CoachRegis coachRegis, ModelMap m, HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("id");
		if(credentials == null)
		{
			m.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		List<CoachRegis> coachList = coachReqRepos.findAll();
		List<SponsorRegis> sponsorRegis	=sponsorReqRepos.findAll();
		int sizeSponsor=sponsorRegis.size();
		m.put("sizeSponsor",sizeSponsor);
		m.addAttribute("coachList", coachList);

		return "coachRequest";
	}

	@RequestMapping("/coachAcpt")
	public String coachAcpt(ModelMap map, HttpServletRequest req, HttpSession session) {
		String coachReq = (String) req.getParameter("EventRegistration");

		String notify[] = coachReq.split(":");

		String eventId = notify[0];
		String coachId = notify[1];

		String status = "Approved";
		String request = "";

		Event temp = eventRepository.getOne(eventId);
		CoachRegis coachtemp = coachReqRepos.getCoachRequest(eventId, coachId);

		NotificationCoach notification = new NotificationCoach(temp.getEventId(), temp.getEventName(), temp.getDate(),
				temp.getVenue(), coachtemp.getCoachId(), coachtemp.getCoachName(), status);

		notificationCoachRepos.save(notification);

		coachReqRepos.deleteById(eventId);

		map.put("req", request + " request is Accepted Successfully");
		return "redirect:/coachRequests";
	}

	@RequestMapping("/coachReject")
	public String coachDelete(ModelMap map, HttpServletRequest req, HttpSession session) {

		String coachReq = (String) req.getParameter("EventRegistration");

		String notify[] = coachReq.split(":");

		String eventId = notify[0];
		String coachId = notify[1];

		String status = "Reject";
		String request = "";

		Event temp = eventRepository.getOne(eventId);
		CoachRegis coachtemp = coachReqRepos.getCoachRequest(eventId, coachId);

		NotificationCoach notification = new NotificationCoach(temp.getEventId(), temp.getEventName(), temp.getDate(),
				temp.getVenue(), coachtemp.getCoachId(), coachtemp.getCoachName(), status);

		notificationCoachRepos.save(notification);

		coachReqRepos.deleteById(eventId);

		map.put("req", request + " request is Accepted Successfully");
		return "redirect:/coachRequests";
	}

	@RequestMapping("headerHome")
	public String organizerHomeForHeader(ModelMap map) {
		List<SponsorRegis> sponsorRegis	=sponsorReqRepos.findAll();
		int sizeSponsor=sponsorRegis.size();
	    List<CoachRegis> coachRegis=coachReqRepos.findAll();
	    int sizeCoach=coachRegis.size();
		map.put("sizeSponsor",sizeSponsor);
		map.put("sizeCoach",sizeCoach);
		return "organizerHome";
	}

}
