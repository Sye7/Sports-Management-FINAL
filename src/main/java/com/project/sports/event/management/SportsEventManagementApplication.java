package com.project.sports.event.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories(basePackages = {"com.*"})
@EntityScan(basePackages = {"com.*"})


public class SportsEventManagementApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(SportsEventManagementApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SportsEventManagementApplication.class, args);
	}

}
