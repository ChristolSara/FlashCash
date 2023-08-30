package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.AccountRepository;
import fr.greta.FlashCash.service.AccountService;
import fr.greta.FlashCash.service.SessionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class accountControllerRest {
    private AccountService accountService;
    private AccountRepository accountRepository;
    private final SessionService sessionService;

    @GetMapping("/listAccount")
    List<Account> account() {
     return accountRepository.findAll();
    }


}
