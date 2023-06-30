package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.AccountService;
import fr.greta.FlashCash.service.BeneficiaryService;
import fr.greta.FlashCash.service.SessionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class accountController {
    private AccountService accountService;
    private final BeneficiaryService beneficiaryService;
    private final SessionService sessionService;

    @GetMapping("/account")
    String account(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute(user);
        Account account = new Account();
        model.addAttribute(account);
        return "account";
    }

    @PostMapping("/addAccount")
    public String addAccount(@Valid Account account, BindingResult result, Model model) {
        User user = sessionService.sessionUser();
        account.setUser(user);

        if (!result.hasErrors()) {
            accountService.addAccount(account, result);
            model.addAttribute(user);
            return "account";
        }


        model.addAttribute(user);
        return "404";
    }


}