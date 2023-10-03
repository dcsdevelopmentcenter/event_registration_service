package com.dcs.user.registration.facade;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.converter.Converter;
import com.dcs.user.registration.model.RegistrationData;
import com.dcs.user.registration.persistent.UserEntity;
import com.dcs.user.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRegistrationFacade implements RegistrationFacade
{
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private Converter<RegistrationData, UserEntity> registrationConverter;
	@Override
	public String register(final RegistrationData registrationData)
	{
		UserEntity userEntity = registrationConverter.convert(registrationData);
		return registrationService.register(userEntity);

	}
}
