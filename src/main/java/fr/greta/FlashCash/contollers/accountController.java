package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.AccountService;
import fr.greta.FlashCash.service.SessionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class accountController {
    private AccountService accountService;
    private final SessionService sessionService;

    @GetMapping("/account")
    String account(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute(user);
        model.addAttribute("account",user.getAccount());
        return "account";
    }

    @PostMapping("/addAccount")
    public String addAccount(@Valid Account account, BindingResult result, Model model) {
        model.addAttribute("user",sessionService.sessionUser());
        model.addAttribute(accountService.addAccount(account,result));
        return "/home";
    }


}
