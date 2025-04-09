package com.aiactions.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AiActionsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiActionsBackendApplication.class, args);
	}

}
