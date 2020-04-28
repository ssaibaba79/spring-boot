package io.ss.spring.boot.ws.model;

public class User {
	
	String id;
	
	String firstName;
	
	String lastName;
	
	String email;
	
	String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		this.firstName = (firstName != null) ? firstName : this.firstName;			;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = (lastName != null) ? lastName : this.lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = (email != null) ? email : this.email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = (phone != null) ? phone : this.phone;
	}
		
	public void copyFrom(User user) {
		if (user != null) {
			setFirstName(user.getFirstName());
			setLastName(user.getLastName());
			setEmail(user.getEmail());
			setPhone(user.getPhone());
		}
	}

}
