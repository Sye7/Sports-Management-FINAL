package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Sponsor {

	@Id
	@NotNull(message="Id can't be empty")
	@Pattern(regexp="[A-Za-z0-9]{8,}",message="Id must be alphanumeric and should be of min 8 char")
	private String sponsorId;
	

	@NotNull(message = "Password can't be null")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^//d ^//w]).{6,20})", message = " Password must contain atleast one digit, one lowercase, one uppercase characters, and one special symbols and should be of 6 characters and maximum of 20")
	private String password;
	
	@NotEmpty(message = "Sponsored product can't be empty")
	private String sponsorProduct;
	@NotEmpty(message = "Location can't be empty")
	private String sponsorshipLocation;
	
	
	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSponsorProduct() {
		return sponsorProduct;
	}

	public void setSponsorProduct(String sponsorProduct) {
		this.sponsorProduct = sponsorProduct;
	}

	public String getSponsorshipLocation() {
		return sponsorshipLocation;
	}

	public void setSponsorshipLocation(String sponsorshipLocation) {
		this.sponsorshipLocation = sponsorshipLocation;
	}

	public Sponsor(String sponsorId, String password, String sponsorProduct, String sponsorshipLocation) {
		super();
		this.sponsorId = sponsorId;
		this.password = password;
		this.sponsorProduct = sponsorProduct;
		this.sponsorshipLocation = sponsorshipLocation;
	}

	@Override
	public String toString() {
		return "Sponser [sponsorId=" + sponsorId + ", password=" + password + ", sponsorProduct=" + sponsorProduct
				+ ", sponsorshipLocation=" + sponsorshipLocation + "]";
	}

}
