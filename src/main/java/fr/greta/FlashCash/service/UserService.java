package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SessionService sessionService;

    public User addUser(User user) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }

    public List<Beneficiary> beneficiaryList(){
        User user=sessionService.sessionUser();
        return user.getBeneficiaryList();
    }
}