package com.project.sports.event.management.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Coach;
import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.NotificationCoach;
import com.project.sports.event.management.model.NotificationSponsor;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.model.SponsorRegis;
import com.project.sports.event.management.repository.CoachRepository;
import com.project.sports.event.management.repository.EventRepository;
import com.project.sports.event.management.repository.NotificationSponsorRepos;
import com.project.sports.event.management.repository.SponsorRepository;
import com.project.sports.event.management.repository.SponsorReqRepos;

@Controller
@SessionAttributes({ "creden", "event" })
public class SponsorLoginController {

	@Autowired
	SponsorRepository sponsorRepository;

	@Autowired
	SponsorReqRepos sponsorReqRepos;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	NotificationSponsorRepos notificationSponsorRepos;

	// Show Sponsor Login Page
	@RequestMapping("/sponsorLogin")
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		credentials = new Credentials();

		return "sponsorLogin";
	}

	// Sponsor Login Validation page
	@RequestMapping(value = "/sponsorSub", method = RequestMethod.POST)
	public String validateSponsorRegistration(@ModelAttribute("credentials") Credentials credentials, ModelMap map,
			HttpSession session) {
		Sponsor sponsor = sponsorRepository.getSponsor(credentials.getId(), credentials.getPassword());

		if (sponsor != null) {

			session.setAttribute("creden", credentials);
			return "redirect:/sportshome";
		}


		map.addAttribute("failed", "Credentials does not matched");
		return "sponsorLogin";

	}

	// Show sponsor Registration Page
	@RequestMapping(value = "/sponsorRegistration", method = RequestMethod.GET)
	public String showSponsorRegistration(@ModelAttribute("sponsor") Sponsor sponsor) {
		sponsor = new Sponsor();
		return "sponsorRegisPage";
	}

	// sponsor Submission
	@RequestMapping(value = "/sponsorRegisterUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("sponsor") Sponsor sponsor, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "sponsorRegisPage";
		}
		
		Optional<Sponsor> sponsorExists = sponsorRepository.findById(sponsor.getSponsorId());

		if (sponsorExists.isPresent()) {
			Sponsor temp = sponsorExists.get();

			if (temp.getSponsorId().equals(sponsor.getSponsorId())) {
				map.addAttribute("failed", "This Id is already taken.");
				return "sponsorRegisPage";
			}
		}
		
		sponsorRepository.save(sponsor);
		map.put("successful", "Your details are submitted successfully");
		map.addAttribute("credentials", new Credentials());
		return "sponsorLogin";
	}

	@RequestMapping("/sportshome")
	public String sportsHome(ModelMap map, HttpSession session) {

		Credentials credentials = (Credentials) session.getAttribute("creden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		List<Event> li = eventRepository.findAll();
		List<NotificationSponsor> temp = notificationSponsorRepos.findAll();
		int size=temp.size();
		session.removeAttribute("event");
		session.setAttribute("event", li);
        map.put("sponsorSize",size);
		return "SponsorHome";
	}

	@RequestMapping("/requestSponsorship")
	public String requestSponsorship(HttpServletRequest request, HttpSession session, ModelMap map) {
		
		

		Credentials credentials = (Credentials) session.getAttribute("creden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		String sponsorId = credentials.getId();
		
		
		Optional<Sponsor> sponsorExists = sponsorRepository.findById(sponsorId);
		
		Sponsor sponsor = null;
		if(sponsorExists.isPresent())
			sponsor = sponsorExists.get();

		String sponsorName = sponsor.getSponsorProduct();

		String e = request.getParameter("EventRegistration");
		String eventEntity[] = e.split(":");

		String eventId = eventEntity[0];
		String eventName = eventEntity[1];

		SponsorRegis sponsorReq = new SponsorRegis(eventId, eventName, sponsorId, sponsorName);
		sponsorReqRepos.save(sponsorReq);

		List<Event> list = (List<Event>) session.getAttribute("event");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEventId().equals(eventId) && list.get(i).getEventName().equals(eventName)) {
				list.remove(i);
				break;
			}
		}

		session.removeAttribute("event");
		session.setAttribute("event", list);

		if (list.isEmpty())
			session.invalidate();

		return "redirect:/sportshome";
	}

	@RequestMapping("sponsorNotify")
	public String coachNotification(ModelMap map, HttpSession session) {

		Credentials credentials = (Credentials) session.getAttribute("creden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		

		List<NotificationSponsor> temp = notificationSponsorRepos.findAll();

		List<NotificationSponsor> notificationSponsorList = new ArrayList<NotificationSponsor>();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getSponsorId().equals(credentials.getId())) {
				notificationSponsorList.add(temp.get(i));
			}
		}

		map.addAttribute("notificationSponsorList", notificationSponsorList);

		return "sponsorNotification";
	}

	@RequestMapping("/remsponsorNotify")
	public String deleteNotification(HttpServletRequest request, HttpSession session, ModelMap map) {

		Credentials credentials = (Credentials) session.getAttribute("creden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		String sponsorId = credentials.getId();

		String e = request.getParameter("EventRegistration");
		String eventEntity[] = e.split(":");

		String eventId = eventEntity[0];

		notificationSponsorRepos.deleteById(eventId);

		return "redirect:/sponsorNotify";
	}
	

}
