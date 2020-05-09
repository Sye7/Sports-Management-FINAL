package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotificationSponsor {

	@Id
	private String eventId;
	private String eventName;
	private String date;
	private String venue;
	private String sponsorId;
	private String sponsorname;
	private String status;
	

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponsorname() {
		return sponsorname;
	}

	public void setSponsorname(String sponsorname) {
		this.sponsorname = sponsorname;
	}


	public NotificationSponsor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public NotificationSponsor(String eventId, String eventName, String date, String venue, String sponsorId,
			String sponsorname, String status) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.date = date;
		this.venue = venue;
		this.sponsorId = sponsorId;
		this.sponsorname = sponsorname;
		this.status = status;
	}

	@Override
	public String toString() {
		return eventId +":"+  sponsorId + ":";
	}



}
