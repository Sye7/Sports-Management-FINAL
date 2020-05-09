package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotificationCoach {

	@Id
	private String eventId;
	private String eventName;
	private String date;
	private String venue;
	private String coachId;
	private String coachName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return eventId + ":" + coachId + ":";
	}

	public NotificationCoach(String eventId, String eventName, String date, String venue, String coachId,
			String coachName, String status) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.date = date;
		this.venue = venue;
		this.coachId = coachId;
		this.coachName = coachName;
		this.status = status;
	}

	public NotificationCoach() {
		super();
		// TODO Auto-generated constructor stub
	}

}
