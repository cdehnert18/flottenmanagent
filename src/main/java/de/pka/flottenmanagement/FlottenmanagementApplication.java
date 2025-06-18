package de.pka.flottenmanagement;

import de.pka.flottenmanagement.repository.PositionRepository;
import de.pka.flottenmanagement.repository.UgvRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlottenmanagementApplication {

	// private static final Logger log = LoggerFactory.getLogger(FlottenmanagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlottenmanagementApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UgvRepository ugvRepo, PositionRepository posRepo) {
		return (args) -> {
			/*
			posRepo.save(new Position(42, 69));
			
			ugvRepo.save(new Ugv("Speedster", 10, 100));
			ugvRepo.save(new Ugv("Speedster1", 10, 100));
			ugvRepo.save(new Ugv("Speedster2", 10, 100));
			ugvRepo.save(new Ugv("Speedster3", 10, 100));

			for (Ugv ugv : ugvRepo.findAll())
				System.out.println(ugv);


			for (Position pos : posRepo.findAll())
				System.out.println(pos);
			*/
		};
	}
}

