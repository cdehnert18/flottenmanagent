package de.pka.flottenmanagement;

import de.pka.flottenmanagement.model.PositionRepository;
import de.pka.flottenmanagement.model.UGVRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlottenmanagementApplication {

	private static final Logger log = LoggerFactory.getLogger(FlottenmanagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlottenmanagementApplication.class, args);
	}

}

@Bean
public CommandLineRunner demo(UGVRepository ugvRepo, PositionRepository posRepo) {
	return (args) -> {
		;
	};
}