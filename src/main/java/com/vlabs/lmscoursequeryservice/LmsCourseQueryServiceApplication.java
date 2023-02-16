package com.vlabs.lmscoursequeryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class LmsCourseQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsCourseQueryServiceApplication.class, args);
	}

	@Bean
	public StringJsonMessageConverter jsonConverter() {
		return new StringJsonMessageConverter();
	}
}
