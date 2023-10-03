package com.dcs.user.registration.apis;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.exceptions.RegistrationValidationException;
import com.dcs.user.registration.facade.RegistrationFacade;
import com.dcs.user.registration.model.RegistrationData;
import com.dcs.user.registration.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.api.base.url}/register")
public class UserRegistrationController
{

	private final ValidationService<RegistrationData> validationService = data -> true;
	@Autowired
	private RegistrationFacade registrationFacade;

	@PostMapping
	public ResponseEntity<String> register(@RequestBody RegistrationData registrationData)
	{
		if (validationService.validate(registrationData))
		{
			String uuid = registrationFacade.register(registrationData);
			return ResponseEntity.status(HttpStatus.CREATED).body(uuid);
		}
		throw new RegistrationValidationException("test");
	}

	@ExceptionHandler(RegistrationValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleRegistrationValidationException(
			RegistrationValidationException exception)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}
