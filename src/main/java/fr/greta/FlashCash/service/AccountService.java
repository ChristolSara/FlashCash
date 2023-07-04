package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.AccountRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final SessionService sessionService;

    public Account addAccount(@Valid Account account, BindingResult result) {

        User user = sessionService.sessionUser();
        if ((!result.hasErrors()) && (user.getAccount() == null)) {
            account.setUser(user);
            return accountRepository.save(account);
        }
        return account;
    }


}
