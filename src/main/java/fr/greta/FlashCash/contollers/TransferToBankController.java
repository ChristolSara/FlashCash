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
    private final BeneficiaryService beneficiaryService;

    private final UserService userService;
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
    public String addTransferToBank(Model model, Operation operation) {
        User user = sessionService.sessionUser();
        Account account = user.getAccount();

        float amountUser = account.getAmount();
        float amount = operation.getAmount();

        if(amountUser > amount){

            account.setAmount(amountUser - amount);
            user.setAccount(account);
            model.addAttribute(user);
            return "/Transfer-To-Bank";
        }
        model.addAttribute(user);
        return "/Transfer-To-Bank";
    }

    @GetMapping("/Transfer-To-Benef")
    public String transferToBenef(Model model) {
        Operation operation = new Operation();
        model.addAttribute(operation);

        User user = sessionService.sessionUser();
        List<Beneficiary> beneficiaryList = user.getBeneficiaryList();
        model.addAttribute(beneficiaryList);
        model.addAttribute(user);

        return "/Transfer-To-Benef";
    }



}
