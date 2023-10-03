package com.dcs.user.registration.persistent;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "user")
public class UserEntity implements Serializable
{

	private static final long serialVersionUID = 6083737653826650651L;
	@Id
	private String userPK;
	@Indexed(unique = true)
	private String userId;
	@Indexed(unique = true)
	private String phoneNumber;
	private String profilePK;
	@Field
	private Status status = Status.INACTIVE;
	private String password;
	private LocalDate registrationDate;

	public String getUserPK()
	{
		return userPK;
	}

	public void setUserPK(final String userPK)
	{
		this.userPK = userPK;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(final String userId)
	{
		this.userId = userId;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePK()
	{
		return profilePK;
	}

	public void setProfilePK(final String profilePK)
	{
		this.profilePK = profilePK;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(final Status status)
	{
		this.status = status;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public LocalDate getRegistrationDate()
	{
		return registrationDate;
	}

	public void setRegistrationDate(final LocalDate registrationDate)
	{
		this.registrationDate = registrationDate;
	}
}
