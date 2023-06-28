package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.Operation;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.SessionService;
import fr.greta.FlashCash.service.TransferToBankService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TransferToBankController {
    private final TransferToBankService transferToBankService;

    private final SessionService sessionService;

    @PostMapping("/addTransfer")
    public String addTransfer(@Valid Operation operation, BindingResult result, Model model){

        return "Transfer-To-Bank";
    }
    @GetMapping("/Transfer-To-Bank")
    public String transferToBank(Model model){
        User user=sessionService.sessionUser();
        model.addAttribute(user);
        Operation operation = new Operation();
        model.addAttribute(operation);
        return "Transfer-To-Bank";
    }
}
