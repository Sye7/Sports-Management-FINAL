package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;


@Entity
public class Sports {
	@NotEmpty(message = "Sport name can't be null")
	@Pattern(regexp ="[\\w\\s]{4,20}", message="Contains only alphabets")
	private String sportsName;

	@Pattern(regexp ="[\\w]{4,20}", message="Contains only alphabets")
	@NotEmpty(message = "Sport type can't be null")
	private String sportsType;
	
	@NotNull(message = "noOfPlayers can't be null")
	@Pattern(regexp = "(^[1-9]\\d{0,1})", message="Should be in the range of 1-100")
	private String noOfPlayers;
	@NotEmpty(message = "time can't be empty")
	@Pattern(regexp = "^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])(:([0-5]?[0-9]))?$", message = "Time should be given in a:b format")
	private String timeOfMatch;

	@Id
	@NotNull(message = "Sports id can't be empty")
	@Pattern(regexp ="[0-9]{4,8}", message="Should be Integer between 4-8 digits")
	private String sportsId;

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSportsType() {
		return sportsType;
	}

	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}

	public String getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(String noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getTimeOfMatch() {
		return timeOfMatch;
	}

	public void setTimeOfMatch(String timeOfMatch) {
		this.timeOfMatch = timeOfMatch;
	}

	public String getSportsId() {
		return sportsId;
	}


	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}

	public Sports(
			@NotEmpty(message = "Sport name can't be null") @Pattern(regexp = "[\\w]{4,20}", message = "Contains only alphabets") String sportsName,
			@Pattern(regexp = "[\\w]{4,20}", message = "Contains only alphabets") @NotEmpty(message = "Sport type can't be null") String sportsType,
			@NotNull(message = "noOfPlayers can't be null") @Pattern(regexp = "(^[1-9]\\d{0,1})", message = "Should be in the range of 1-100") String noOfPlayers,
			@NotEmpty(message = "time can't be empty") @Pattern(regexp = "^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])(:([0-5]?[0-9]))?$", message = "Time should be given in a:b format") String timeOfMatch,
			@NotNull(message = "Sports id can't be empty") @Pattern(regexp = "[0-9]{4,8}", message = "Should be Integer between 4-8 digits") String sportsId) {
		super();
		this.sportsName = sportsName;
		this.sportsType = sportsType;
		this.noOfPlayers = noOfPlayers;
		this.timeOfMatch = timeOfMatch;
		this.sportsId = sportsId;
	}

	

}
