package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.BeneficiaryRepository;
import fr.greta.FlashCash.repository.UserRepository;
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
public class BenefController {
    private final SessionService sessionService;

    private BeneficiaryService beneficiaryService;


    @GetMapping("/beneficiary")
    public String listBeneficiary(Model model) {
        User user = sessionService.sessionUser();
        Beneficiary beneficiary = new Beneficiary();
        model.addAttribute(user);
        model.addAttribute("beneficiary",new Beneficiary());
        model.addAttribute("listBeneficiary",user.getBeneficiaryList());
        return "/beneficiary";
    }

    @PostMapping("/addBeneficiary")
    public String addBeneficiary(@Valid Beneficiary beneficiary, BindingResult result, Model model) {
        model.addAttribute("user",sessionService.sessionUser());
        model.addAttribute("account",sessionService.sessionUser().getAccount());
         model.addAttribute(beneficiaryService.addBeneficiary(beneficiary, result));
        return "/home";
    }


}
