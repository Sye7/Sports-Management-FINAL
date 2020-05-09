package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CoachRegis {

	
	@Id
	private String eventId;
	private String eventName;
	private String coachId;
	private String coachName;

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

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public CoachRegis(String eventId, String eventName, String coachId, String coachName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.coachId = coachId;
		this.coachName = coachName;
	}

	public CoachRegis() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return eventId + ":" + coachId + ":";
	}

}
