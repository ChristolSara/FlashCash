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
        beneficiary.setUser(user);
        Collection<Beneficiary> beneficiaryList = user.getBeneficiaryList();

        if(beneficiaryList.size()== 0 ){
            beneficiaryList.add(beneficiary);
            userRepository.save(user);
          beneficiaryRepository.save(beneficiary);


        }else{
            for (Beneficiary beneficiary1 : beneficiaryList) {

                if (!(result.hasErrors()) && !(beneficiary1.getEmail().equals(beneficiary.getEmail()))) {


                    user.getBeneficiaryList().add(beneficiary);

                    userRepository.save(user);
                    return beneficiaryRepository.save(beneficiary);

                }


            }

        }



        return beneficiary;
    }


    public void deleteById(Integer id) {
        beneficiaryRepository.deleteById(id);
    }
}
