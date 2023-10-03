package com.dcs.user.registration.service;
/*
 * Copyright (c)  Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.exceptions.EventPlanningRuntimeException;

@FunctionalInterface
public interface ValidationService<T> {
	boolean validate(T data) throws EventPlanningRuntimeException;
}
