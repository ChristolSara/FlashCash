package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "user/users";
    }

    @GetMapping("user/validate")
    public String addUser( User user, Model model, BindingResult result){

        userRepository.save(user);

        return "user/signUp";
    }
    @PostMapping("user/update/{id}")
    public  String updateUser(Integer id,Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));

        return "user/update";
    }


}
