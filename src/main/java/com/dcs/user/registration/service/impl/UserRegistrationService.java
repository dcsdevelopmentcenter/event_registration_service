package com.dcs.user.registration.service.impl;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import com.dcs.user.registration.config.security.EventPlannerEncryptionUtil;
import com.dcs.user.registration.exceptions.EventPlanningRuntimeException;
import com.dcs.user.registration.model.VerifyRequest;
import com.dcs.user.registration.persistent.UserEntity;
import com.dcs.user.registration.persistent.repos.RegistrationRepo;
import com.dcs.user.registration.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRegistrationService implements RegistrationService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);
	@Value("${application.api.aws.verification.lambda.url}")
	private String verificationUrl;
	@Autowired
	private RegistrationRepo registrationRepo;
	@Autowired
	private EventPlannerEncryptionUtil encryptionUtil;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String register(final UserEntity  userEntity)
	{
		String hashesPassword = encryptionUtil.encrypt(userEntity.getPassword());
		userEntity.setPassword(hashesPassword);
		UserEntity entity = registrationRepo.save(userEntity);
		sendVerification(userEntity);
		return entity.getUserPK();
	}

	private void sendVerification(final UserEntity userEntity)
	{
		VerifyRequest request = new VerifyRequest();
		request.setEmail(userEntity.getUserId());
		ObjectMapper mapper = new ObjectMapper();

		try
		{
			final  String jsonRequest = mapper.writeValueAsString(request);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//headers.setAccept(List.of(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			restTemplate.exchange(verificationUrl, HttpMethod.POST, entity,String.class);
		}catch (JsonProcessingException e)
		{
			LOGGER.error(e.getMessage(),e);
			throw new EventPlanningRuntimeException(e);
		}
	}
}
