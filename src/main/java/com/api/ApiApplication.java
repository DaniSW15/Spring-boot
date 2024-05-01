package com.api;

import com.api.entity.Contact;
import com.api.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) { SpringApplication.run(ApiApplication.class, args); }

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Contact> contacts = Arrays.asList(
						new Contact("Daniel", "dani@gmail.com", LocalDateTime.now())
				);

				contactRepository.saveAll(contacts);
			}
		};
	}

	@Bean
	ModelMapper modelMapper() {
        return new ModelMapper();
	}
}
