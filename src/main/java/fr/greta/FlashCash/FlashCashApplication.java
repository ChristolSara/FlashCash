package fr.greta.FlashCash;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCashApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountRepository accountRepository) {
		return args -> {

			accountRepository.save(new Account(1, "swift", 555, "hhhh", null));

		};
	}
}
