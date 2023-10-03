package com.dcs.user.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Copyright (c)  Seiko Epson. All rights reserved.
 */
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class EventPlanningRuntimeException extends RuntimeException {
	public EventPlanningRuntimeException(){
		super();
	}

	public EventPlanningRuntimeException(String message){
		super(message);
	}

	public EventPlanningRuntimeException(Throwable cause) {
		super(cause);
	}
}
