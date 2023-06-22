package fr.greta.FlashCash;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.AccountRepository;
import fr.greta.FlashCash.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class FlashCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCashApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountRepository accountRepository, UserRepository userRepository) {
		return args -> {
//
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			User user1 = new User(1,"sara","christol",new Date(),"0600606","1 rue henri ","sara@mail.com",encoder.encode("0000"),null,null);
			userRepository.save(user1);
//			Account account1 = new Account(1, "swift", 555, "hhhh",user1,null);
//			accountRepository.save(account1);


		};
	}
}
