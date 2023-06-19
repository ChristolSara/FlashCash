package fr.greta.FlashCash.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping("/home")
    public String home(){
        return "/home";
    }
    @GetMapping("/signIn")
    public String signIn(){
        return "user/signIn";
    }
}
