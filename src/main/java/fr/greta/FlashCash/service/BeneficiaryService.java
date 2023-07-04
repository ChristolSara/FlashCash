package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.BeneficiaryRepository;
import fr.greta.FlashCash.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
    private final UserRepository userRepository;
    private final SessionService sessionService;

    public Beneficiary addBeneficiary(@Valid Beneficiary beneficiary, BindingResult result) {

        User user = sessionService.sessionUser();
        Collection<Beneficiary> beneficiaryList = user.getBeneficiaryList();

        if ((!result.hasErrors()) && (!beneficiaryList.contains(beneficiary))) {

            beneficiary.setUser(user);
            user.getBeneficiaryList().add(beneficiary);

            userRepository.save(user);
            return beneficiaryRepository.save(beneficiary);
        }
        return beneficiary;
    }





}
