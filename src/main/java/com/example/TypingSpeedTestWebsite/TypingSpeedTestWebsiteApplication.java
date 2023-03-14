package com.example.TypingSpeedTestWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.TypingSpeedTestWebsite.controllers", "com.example.TypingSpeedTestWebsite.services"})
@SpringBootApplication
public class TypingSpeedTestWebsiteApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TypingSpeedTestWebsiteApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TypingSpeedTestWebsiteApplication.class, args);
	}

}
