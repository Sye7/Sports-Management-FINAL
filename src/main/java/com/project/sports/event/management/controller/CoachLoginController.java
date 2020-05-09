package com.project.sports.event.management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.sports.event.management.model.Coach;
import com.project.sports.event.management.model.CoachRegis;
import com.project.sports.event.management.model.Credentials;
import com.project.sports.event.management.model.Event;
import com.project.sports.event.management.model.NotificationCoach;
import com.project.sports.event.management.model.Organizer;
import com.project.sports.event.management.model.Sponsor;
import com.project.sports.event.management.model.SponsorRegis;
import com.project.sports.event.management.repository.CoachRepository;
import com.project.sports.event.management.repository.CoachReqRepos;
import com.project.sports.event.management.repository.EventRepository;
import com.project.sports.event.management.repository.NotificationCoachRepos;

@Controller
@SessionAttributes({ "coachCreden", "eventList" })
public class CoachLoginController {
	@Autowired
	CoachRepository coachRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	CoachReqRepos coachReqRepos;

	@Autowired
	NotificationCoachRepos notificationCoachRepos;

	// Show coach Login Page
	@RequestMapping("/coachLogin")
	public String getLoginPage(@ModelAttribute("credentials") Credentials credentials) {
		credentials = new Credentials();
		return "coachLogin";
	}

	// Coach Login
	@RequestMapping(value = "/coachSub", method = RequestMethod.POST)
	public String validateCoachLogin(@ModelAttribute("credentials") Credentials credentials, ModelMap map,
			HttpSession session) {
		Coach coach = coachRepository.getCoach(credentials.getId(), credentials.getPassword());

		if (coach != null) {

			session.setAttribute("coachCreden", credentials);
			return "redirect:/coachHome";
		}

		map.addAttribute("failed", "Credentials does not matched");
		return "coachLogin";

	}

	// Show coach Registration Page
	@RequestMapping("/coachRegistration")
	public String showCoachRegistration(@ModelAttribute("coach") Coach coach) {

		coach = new Coach();
		return "coachRegisPage";
	}

	// coach Submission
	@RequestMapping(value = "/coachRegisterUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("coach") Coach coach, BindingResult bindingResult, ModelMap map) {

		if (bindingResult.hasErrors()) {
			System.out.println("ui details not correct");
			return "coachRegisPage";
		}

		Optional<Coach> coachExists = coachRepository.findById(coach.getCoachId());

		if ( coachExists.isPresent()) 
		{
			Coach temp = coachExists.get();
			
			if(temp.getCoachId().equals(coach.getCoachId()))
			{
			System.out.println();
			System.out.println(coach.getCoachId() + "  " + temp.getCoachId());
			map.addAttribute("failed", "This Id is already taken.");
			return "coachRegisPage";
		}
	}

		else {
			coachRepository.save(coach);
			map.put("successful", coach.getFirstName() + " your details are submitted successfully");
			map.addAttribute("credentials", new Credentials());
			return "coachLogin";
		}
		return "coachRegisPage";
	}

	@RequestMapping("/coachHome")
	public String coachHome(ModelMap map, HttpSession session) {
		
		Credentials credentials = (Credentials) session.getAttribute("coachCreden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}

		List<Event> li = eventRepository.findAll();
		List<NotificationCoach> temp = notificationCoachRepos.findAll();
		int coachSize=temp.size();
		session.removeAttribute("eventList");
		session.setAttribute("eventList", li);
        map.put("coachSize", coachSize);
		return "coachHome";
	}

	@RequestMapping("/requestSponsorshipCoach")
	public String requestSponsorshipCoach(HttpServletRequest request, HttpSession session, ModelMap map) {

		Credentials credentials = (Credentials) session.getAttribute("coachCreden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		
		String coachId = credentials.getId();
		Optional<Coach> coachExists = coachRepository.findById(coachId);

		Coach coach = null;
		
		if(coachExists.isPresent())
			coach = coachExists.get();
		
		String coachName = coach.getFirstName() + " " + coach.getLastName();

		String e = request.getParameter("EventRegistration");
		String eventEntity[] = e.split(":");

		System.out.println(e);

		String eventId = eventEntity[0];
		String eventName = eventEntity[1];

		CoachRegis coachReq = new CoachRegis(eventId, eventName, coachId, coachName);

		coachReqRepos.save(coachReq);

		List<Event> list = (List<Event>) session.getAttribute("eventList");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEventId().equals(eventId) && list.get(i).getEventName().equals(eventName)) {
				list.remove(i);
				break;
			}
		}

		session.removeAttribute("eventList");
		session.setAttribute("eventList", list);

		if (list.isEmpty())
			session.invalidate();

		return "redirect:/coachHome";
	}

	@RequestMapping("coachNotify")
	public String coachNotification(ModelMap map, HttpSession session) {

		Credentials credentials = (Credentials) session.getAttribute("coachCreden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		System.out.println(credentials + "yasir ");

		List<NotificationCoach> temp = notificationCoachRepos.findAll();

		List<NotificationCoach> notificationCoachList = new ArrayList<NotificationCoach>();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getCoachId().equals(credentials.getId())) {
				notificationCoachList.add(temp.get(i));
			}
		}

		map.addAttribute("notificationCoachList", notificationCoachList);

		return "coachNotification";
	}

	@RequestMapping("/remcoachNotify")
	public String deleteNotification(HttpServletRequest request, HttpSession session, ModelMap map) {

		Credentials credentials = (Credentials) session.getAttribute("coachCreden");
		if(credentials == null)
		{
			map.addAttribute("session", "Your Session is Expired please Login Again..");
			return "forward:/home";
		}
		String coachId = credentials.getId();

		String e = request.getParameter("EventRegistration");
		String eventEntity[] = e.split(":");

		String eventId = eventEntity[0];

		notificationCoachRepos.deleteById(eventId);

		return "redirect:/coachNotify";
	}

}
