package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class SponsorRegis {
	
	@Id
	private String eventId;
	private String eventName;
	private String sponsorId;
	private String sponsorName;

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

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public SponsorRegis(String eventId, String eventName, String sponsorId, String sponsorName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.sponsorId = sponsorId;
		this.sponsorName = sponsorName;
	}

	public SponsorRegis() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return eventId + ":" + sponsorId + ":";
	}

}
