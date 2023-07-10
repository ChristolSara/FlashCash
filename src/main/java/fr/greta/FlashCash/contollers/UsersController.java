package fr.greta.FlashCash.contollers;

;
import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;

import fr.greta.FlashCash.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;


@Controller
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping("/signUp")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "/signUp";
    }
   @PostMapping("/AddUser")
    public String validateUser(@Valid User user, BindingResult result,Model model) {
        model.addAttribute(userService.addUser(user,result));
        return "/home";
    }
//    @PostMapping("user/update/{id}")
//    public  String updateUser(Integer id,Model model){
//        userService.updateUser(id);
//        model.addAttribute(userService.updateUser(id));
//        return "user/update";
//    }
//    @DeleteMapping(value = "/userdelete")
//    public  void removeUser(User user){
//        userService.deleteUser(user);
//    }


}
