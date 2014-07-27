package com.example.rapid.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "User")
@Scope("prototype")
public class User extends AbstractEntity
{
	@Size(max=20)
	@NotNull
	private String userName;

	@Size(max = 250)
	@NotNull
	private String firstName;
	
	@Size(max=250)
	@NotNull
	private String lastName;

	@Size(max=250)
	private String email;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return this.firstName + " : " + this.lastName;
	}
	
	public boolean isNew()
	{ 
		return (this.getId() == null) ? true : false;
	}
}