package com.example.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}


	// init bean to insert 3 books into h2 database.
	@Bean
	CommandLineRunner initDatabase(PersonRepository repository) {


		return null;
	}

}
