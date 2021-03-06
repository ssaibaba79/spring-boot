package io.ss.spring.boot.ws.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest {

	@NotNull(message="First name is required")
	String firstName;
	
	@NotNull(message="Last name is required")
	String lastname;
	
	@NotNull(message="Email is required")
	@Email
	String email;
	
	@Size(min= 7, max = 12, message="Phone # should be 7-12 characters long")
	String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
