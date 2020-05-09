package com.project.sports.event.management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Coach {

	@Id
	@NotNull(message="Id can't be empty")
	@Pattern(regexp="[A-Za-z0-9]{8,}",message="Id must be alphanumeric and should be of min 8 char")
	private String coachId;
	
	@NotEmpty(message = "First name can't be null")
	private String firstName;
	
	@NotEmpty(message = "Last name can't be null")
	private String lastName;
	
	@NotNull(message = "Age name can't be null")
	@Min(35)
	@Max(58)
	private String age;
	private String gender;
	

	@NotNull(message = "Contact number can't be null")
	@Pattern(regexp="^[6-9][0-9]{9}",message="Contact must contains digits and should be of 10 char")
	private String contact;
	
	@NotNull(message = "Password can't be null")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^//d ^//w]).{6,20})", message = " Password must contain atleast one digit, one lowercase, one uppercase characters, and one special symbols and should be of 6 characters and maximum of 20")
	private String password;

	
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Coach [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", contact=" + contact + ", coachId=" + coachId + ", password=" + password + "]";
	}

	public Coach(String firstName, String lastName, String age, String gender, String contact, String coachId,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
		this.coachId = coachId;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
