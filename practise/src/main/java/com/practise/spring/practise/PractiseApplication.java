package com.practise.spring.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.practise.spring.PersonDetails.rest")
@EnableJpaRepositories
public class PractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseApplication.class, args);
	}

}
