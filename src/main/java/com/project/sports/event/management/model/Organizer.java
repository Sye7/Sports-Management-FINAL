package com.project.sports.event.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Organizer {


	@Id
	@NotNull(message="Id can't be empty")
	@Pattern(regexp="[A-Za-z0-9]{8,}",message="Id must be alphanumeric and should be of min 8 char")
	private String organizerId;
	
	@NotEmpty(message = "It can't be empty")
	private String firstName;
	
	@NotEmpty(message = "It can't be empty")
	private String lastName;
	
	@NotNull(message = "It can't be empty")
	@Min(25)
	@Max(60)
	private String age;
	private String gender;
	
	@NotNull(message = "It can't be empty")
	@Pattern(regexp="^[6-9][0-9]{9}",message="Must contains digits of 10 char beginning with 6-9")
	private String contact;

	@NotNull(message = "It can't be empty")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^//d ^//w]).{6,20})", message = " Must contain one digit, lowercase, uppercase and one special symbols within 6-20")
	private String password;

	
	/*
	 
	 	(?=.*\d)		#   must contains one digit from 0-9
  		(?=.*[a-z])		#   must contains one lowercase characters
  		(?=.*[A-Z])		#   must contains one uppercase characters
  		(?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
              .		#     match anything with previous condition checking
                {6,20}	#        length at least 6 characters and maximum of 20			
	 */
	
	
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Organizer(String firstName, String lastName, String age, String gender, String contact, String organizerId,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age =  age;
		this.gender = gender;
		this.contact = contact;
		this.organizerId = organizerId;
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



	public String getOrganizerId() {
		return organizerId;
	}



	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Organizer [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", contact=" + contact + ", organizerId=" + organizerId + ", password=" + password + "]";
	}

}
