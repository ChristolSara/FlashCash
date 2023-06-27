package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {
    private UserRepository userRepository;


    public User sessionUser(){
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(springUser.getUsername()).orElseThrow(() ->new RuntimeException("user with mail not found"));
    }
}
