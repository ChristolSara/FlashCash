package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.Operation;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.SessionService;
import fr.greta.FlashCash.service.TransferToBenefService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class TransferToBenefController {
    private final SessionService sessionService;
    private final TransferToBenefService transferToBenefService;
    @GetMapping("/Transfer-To-Benef")
    public String transferToBenef(Model model) {

        User user = sessionService.sessionUser();
        model.addAttribute("operation",new Operation());
        model.addAttribute("beneficiary",new Beneficiary());
        model.addAttribute("listBeneficiary",user.getBeneficiaryList());
        model.addAttribute(user);

        return "/Transfer-To-Benef";
    }
    @PostMapping("/addTransferBenef")
    public String addTransferToBenef(Model model, Operation operation,Beneficiary beneficiary) {

        model.addAttribute(transferToBenefService.addTransferToBenef(operation,beneficiary));
        model.addAttribute("user",sessionService.sessionUser());
        model.addAttribute("account",sessionService.sessionUser().getAccount());
        model.addAttribute("listBeneficiary",sessionService.sessionUser().getBeneficiaryList());

        return "/home";
    }

}
