package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user) {

        Collection<Beneficiary> beneficiaryList = new ArrayList<>();
        user.setBeneficiaryList(beneficiaryList);
        user.setAccount(null);


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        List<User> userList = userRepository.findAll();

        if   ( !userList.contains(user)) {

          return   userRepository.save(user);
        }

        return user;

    }
    public  User updateUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id user"+id));
        userRepository.save(user);
        return user;
    }
    public void deleteUser(User user){

        userRepository.delete(user);
    }

}