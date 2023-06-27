package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.repository.BeneficiaryRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@AllArgsConstructor
public class BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
private  final SessionService sessionService;

    public Beneficiary addBeneficiary(@Valid Beneficiary beneficiary, BindingResult result) {
        if (!result.hasErrors()) {

            beneficiary.setUser(sessionService.sessionUser());
        }
        return   beneficiaryRepository.save(beneficiary);
    }

    public List<Beneficiary> beneficiaryList (){

        return  beneficiaryRepository.findAll();
    }
}
