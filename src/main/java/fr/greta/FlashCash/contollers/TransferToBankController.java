package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.Operation;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.BeneficiaryService;
import fr.greta.FlashCash.service.SessionService;
import fr.greta.FlashCash.service.TransferToBankService;
import fr.greta.FlashCash.service.UserService;
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
public class TransferToBankController {
    private final TransferToBankService transferToBankService;

    private final SessionService sessionService;



    @GetMapping("/Transfer-To-Bank")
    public String transferToBank(Model model) {
        User user = sessionService.sessionUser();
        Account account = user.getAccount();
        model.addAttribute(account);
        model.addAttribute(user);
        Operation operation = new Operation();
        model.addAttribute(operation);
        return "Transfer-To-Bank";
    }
    @PostMapping("/addTransfer")
    public String addTransferToBank(Model model, Operation operation,Beneficiary beneficiary) {
        model.addAttribute(transferToBankService.addTransferToBank(operation));
        model.addAttribute("user",sessionService.sessionUser());
        model.addAttribute("account",sessionService.sessionUser().getAccount());
        model.addAttribute("listBeneficiary",sessionService.sessionUser().getBeneficiaryList());

        return "/home";
    }





}
