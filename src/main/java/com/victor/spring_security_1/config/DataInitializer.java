package com.victor.spring_security_1.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.victor.spring_security_1.model.User;
import com.victor.spring_security_1.repository.UserRepository;

@Configuration
public class DataInitializer {
	
	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			repository.save(new User(null, "admin", "admin@email.com", "ADMIN"));
			repository.save(new User(null, "user", "user@email.com", "USER"));
			repository.save(new User(null, "guest", "guest@email.com", "GUEST"));
		};
	}
}
