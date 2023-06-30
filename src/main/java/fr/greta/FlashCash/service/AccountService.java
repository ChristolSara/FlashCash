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
    private final  AccountRepository accountRepository;
    private final SessionService sessionService;

    public void addAccount(@Valid Account account, BindingResult result) {


        account.setUser(sessionService.sessionUser());
         accountRepository.save(account);

    }


}
