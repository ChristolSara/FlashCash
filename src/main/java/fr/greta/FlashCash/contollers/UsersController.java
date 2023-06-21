package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/users";
    }

    @GetMapping("user/signUp")
    public String addUser( User user){
        return "user/signUp";
    }
    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            user.setPassword(user.getPassword());

            userRepository.save(user);
            model.addAttribute("users", userRepository.findAll());
            return "redirect:/users";
        }
        return "user/signUp";
    }
    @PostMapping("user/update/{id}")
    public  String updateUser(Integer id,Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));

        userRepository.save(user);
        return "user/update";
    }

    @DeleteMapping("user/delete/{id}")
    public  void removeUser(@PathVariable Integer id){
        User user= userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));
        userRepository.delete(user);
    }


}
