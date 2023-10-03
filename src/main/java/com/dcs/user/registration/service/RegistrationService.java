package com.dcs.user.registration.service;
/*
 * Copyright (c)  Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.model.RegistrationData;
import com.dcs.user.registration.persistent.UserEntity;

public interface RegistrationService {
	String register(UserEntity userEntity);
}
