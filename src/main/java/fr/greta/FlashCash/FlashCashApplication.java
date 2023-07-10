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

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class FlashCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCashApplication.class, args);
	}
	//@Bean
	CommandLineRunner start(UserRepository userRepository,AccountRepository accountRepository) {
		return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//create users for example

            Stream.of("jean", "sara", "ilyane", "rania").forEach(
                    name -> {
                        User user = new User();
                        user.setFirstName(name);
                        user.setLastName(name + "Last");
                        user.setEmail(name + "@gmail.com");
                        user.setPhone("0000");
                        user.setAddress("1 rue " + name);
                        user.setPassword(encoder.encode(name));
                        userRepository.save(user);
                    }
            );
//create account for list of users
            List<String>  bank= List.of(new String[]{"CIC", "LCL", "BANQUE POSTALE", "CREDT AGRICOLE"});
            Random rand = new Random();

            List<User> userList = userRepository.findAll();
            for (User user : userList) {

                Account account = new Account();
                account.setUser(user);
                account.setAmount(200);
                account.setSwift(bank.get(rand.nextInt(bank.size())));
                account.setIban(user.getFirstName() + "2000 2054 6544 4565 w065");
                accountRepository.save(account);

            }
        };

    }
}


