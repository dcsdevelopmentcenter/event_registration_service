package com.dcs.user.registration.exceptions;
/*
 * Copyright (c)  Seiko Epson. All rights reserved.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RegistrationValidationException extends EventPlanningRuntimeException
{

	public RegistrationValidationException(){
		super();
	}

	public RegistrationValidationException(String message){
		super(message);
	}
}
