package com.project.sports.event.management.model;

public class Report {

	private String eventId;
	private String eventName;
	private String sportName;

	public String getEventId() {
		return eventId;
	}

	@Override
	public String toString() {
		return "Report [eventId=" + eventId + ", eventName=" + eventName + ", sportName=" + sportName + "]";
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

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public Report(String eventId, String eventName, String sportName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.sportName = sportName;
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

}
