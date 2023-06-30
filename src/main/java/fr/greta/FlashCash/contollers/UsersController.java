package fr.greta.FlashCash.contollers;

import fr.greta.FlashCash.models.User;

import fr.greta.FlashCash.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@AllArgsConstructor
public class UsersController {

    private UserService userService;


//    @GetMapping("/users")
//    public String allUsers(Model model) {
//        model.addAttribute("users");
//        return "users";
//    }

    @GetMapping("signUp")
    public String addUser( User user){
        return "signUp";
    }
    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            userService.addUser(user);
            return "login";
        }return "signUp";
    }
//    @PostMapping("user/update/{id}")
//    public  String updateUser(Integer id,Model model){
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));
//
//        userRepository.save(user);
//        return "user/update";
//    }
//
//    @DeleteMapping("user/delete/{id}")
//    public  void removeUser(@PathVariable Integer id){
//        User user= userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));
//        userRepository.delete(user);
//    }


}
