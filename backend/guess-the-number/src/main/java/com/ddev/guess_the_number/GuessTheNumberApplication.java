package com.ddev.guess_the_number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GuessTheNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessTheNumberApplication.class, args);
	}

}
