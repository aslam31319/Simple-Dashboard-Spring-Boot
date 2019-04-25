package com.asl.dashboard.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.asl.dashboard.model.MailDTO;

@Configuration
public class BeanConfig {

	@Bean
	@Scope("prototype")
	public MailDTO mailBean() {
		return new MailDTO();
	}
}
