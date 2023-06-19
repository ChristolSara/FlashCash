package fr.greta.FlashCash;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.AccountRepository;
import fr.greta.FlashCash.repository.UserRepository;
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
	CommandLineRunner start(AccountRepository accountRepository, UserRepository userRepository) {
		return args -> {

			Account account1 = new Account(1, "swift", 555, "hhhh");
			accountRepository.save(account1);
			userRepository.save(new User(1,"sara","christol","0600606","1 rue henri ","sara@mail.com","0000",account1));

		};
	}
}
