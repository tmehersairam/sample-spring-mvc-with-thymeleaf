package com.fis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Qr Code", description = "contains the apis", version = "1.0"))
public class SampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
