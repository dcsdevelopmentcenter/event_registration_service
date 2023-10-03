package com.dcs.user.registration.persistent;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "user_profile")
public class Profile implements Serializable
{

	private static final long serialVersionUID = 3153530949103802249L;
	@Id
	private String profilePK;
	private String profileID;
	private String userPK;
	private String firstName;
	private String lastName;
	private String profilePicture;
	private String dateOfBirth;
	private String gender;
	private String country;
	private String mobileNumber;
	private String email;
	private List<Contact> contacts;

	public String getProfilePK()
	{
		return profilePK;
	}

	public void setProfilePK(final String profilePK)
	{
		this.profilePK = profilePK;
	}

	public String getProfileID()
	{
		return profileID;
	}

	public void setProfileID(final String profileID)
	{
		this.profileID = profileID;
	}

	public String getUserPK()
	{
		return userPK;
	}

	public void setUserPK(final String userPK)
	{
		this.userPK = userPK;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getProfilePicture()
	{
		return profilePicture;
	}

	public void setProfilePicture(final String profilePicture)
	{
		this.profilePicture = profilePicture;
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(final String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(final String gender)
	{
		this.gender = gender;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(final String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public List<Contact> getContacts()
	{
		return contacts;
	}

	public void setContacts(final List<Contact> contacts)
	{
		this.contacts = contacts;
	}
}
