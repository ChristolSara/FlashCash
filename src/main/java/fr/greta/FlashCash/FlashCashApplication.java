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
import java.util.stream.Stream;

@SpringBootApplication
public class FlashCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCashApplication.class, args);
	}
	//@Bean
	CommandLineRunner start(UserRepository userRepository) {
		return args -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


			Stream.of("jean","sara","ilyane","rania").forEach(
					name -> {
						User user = new User();
						user.setFirstName(name);
						user.setLastName(name + "Last");
						user.setEmail(name + "@gmail.com");
						user.setBirthday(new Date());
						user.setPhone("0000");
						user.setAdress("1 rue " + name);
						user.setPassword(encoder.encode(name));
						userRepository.save(user);
					}
			);
	    };

}
}