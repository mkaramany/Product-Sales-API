package com.lightspeed.interview.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class Swagger {

	@Bean
	public OpenAPI customizeOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Lightspeed Practical Test Documentation")
						.version("v1.0.0"));
	}
}

