package com.dcs.user.registration.persistent;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "contact")
public class Contact implements Serializable
{
	@Id
	private String contactPK;
	private String contactId;
	private String userId;
	private String userName;
	
}
