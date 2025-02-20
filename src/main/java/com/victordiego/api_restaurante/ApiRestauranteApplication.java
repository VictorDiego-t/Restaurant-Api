package com.victordiego.api_restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestauranteApplication.class, args);
	}

}
