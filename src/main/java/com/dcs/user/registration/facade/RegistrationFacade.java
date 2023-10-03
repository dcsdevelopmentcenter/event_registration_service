package com.dcs.user.registration.facade;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.model.RegistrationData;

public interface RegistrationFacade
{
	String register(RegistrationData registrationData);

}
