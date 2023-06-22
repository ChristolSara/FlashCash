package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class accountController {
private AccountService accountService;

    @PostMapping("/addAccount")
    public String addAccount(@Valid Account account, BindingResult result, Model model) {
        accountService.addAccount(account,result);
        return "home";
    }
}
