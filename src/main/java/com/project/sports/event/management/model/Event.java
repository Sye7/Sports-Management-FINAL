package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Event {

	@Id
	@NotEmpty(message="event Id cannot be null")
	private String eventId;
	@NotEmpty(message="event name cannot be null")
	private String eventName;
	@NotEmpty(message="sports name cannot be null")
	private String sportsName;
	@NotEmpty(message="date cannot be null")
	private String date;
	@NotEmpty(message="time cannot be null")
	private String time;
	@NotEmpty(message="venue cannot be null")
	private String venue;
	
	@Pattern(regexp = "[1-4]{1}", message = "Select slots between 1-4")
	private String noOfSlots;

	public Event(String eventId, String eventName, String sportsName, String date, String time, String venue,
			String noOfSlots) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.sportsName = sportsName;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.noOfSlots = noOfSlots;
	}
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return eventId + ":" + eventName + ":";
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(String noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

}
