package fr.greta.FlashCash.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }
    @GetMapping("/home")
    public String homePage(){
        return "/home";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

}
