package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(@Valid User user , BindingResult result) {

        List<User> userList = userRepository.findAll();
        Collection<Beneficiary> beneficiaryList = new ArrayList<>();
        user.setBeneficiaryList(beneficiaryList);

        if ((!result.hasErrors()) && userList.contains(user)) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            return  userRepository.save(user);
        }

        return user;

    }

}