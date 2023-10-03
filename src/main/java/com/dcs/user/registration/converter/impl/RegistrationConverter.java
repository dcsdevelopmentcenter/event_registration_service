package com.dcs.user.registration.converter.impl;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.converter.Converter;
import com.dcs.user.registration.model.RegistrationData;
import com.dcs.user.registration.persistent.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConverter implements Converter<RegistrationData, UserEntity>
{

	@Override
	public UserEntity convert(final RegistrationData source)
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setPassword(source.password());
		userEntity.setUserId(source.email());
		userEntity.setPhoneNumber(source.mobileNumber());
		return userEntity;
	}
}
