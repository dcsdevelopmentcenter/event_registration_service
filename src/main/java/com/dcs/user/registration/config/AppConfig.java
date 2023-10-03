package com.dcs.user.registration.config;
/*
 * Copyright (c) 2023 Seiko Epson. All rights reserved.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig
{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



}
