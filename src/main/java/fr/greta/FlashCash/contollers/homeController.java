package fr.greta.FlashCash.contollers;


import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class homeController {
    private final SessionService sessionService;
    @GetMapping("/")
    public String home(Model model){
        User user= sessionService.sessionUser();
        model.addAttribute(user);
        return "/home";
    }
    @GetMapping("/home")
    public String homePage(Model model){
        User user=sessionService.sessionUser();
        model.addAttribute(user);
        return "/home";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

}
