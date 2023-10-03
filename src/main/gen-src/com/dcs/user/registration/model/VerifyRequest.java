package com.dcs.user.registration.model;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class VerifyRequest implements Serializable
{
	@JsonProperty("email")
	@NotBlank
	private String email;

	@JsonProperty("email")
	public String getEmail()
	{
		return email;
	}

	@JsonProperty("email")
	public void setEmail(final String email)
	{
		this.email = email;
	}
}
