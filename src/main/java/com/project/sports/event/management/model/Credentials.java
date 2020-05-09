package com.project.sports.event.management.model;

import org.springframework.stereotype.Component;

@Component
public class Credentials {

	private String id;
	private String password;

	@Override
	public String toString() {
		return "Credentials [id=" + id + ", password=" + password + "]";
	}

	public Credentials(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}


}
