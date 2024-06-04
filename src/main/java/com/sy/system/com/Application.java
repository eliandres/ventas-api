package com.sy.system.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    OpenAPI customOpenApi() {
		return new OpenAPI().info(new Info().title("Hola SAT")
				.version("V1.02")
				.description("Simple SAT"));
	}

}
