package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.Operation;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.BeneficiaryRepository;
import fr.greta.FlashCash.repository.OperationRepository;
import fr.greta.FlashCash.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferToBenefService {
    private final OperationRepository operationRepository;
    private final BeneficiaryRepository beneficiaryRepository;
    private final UserRepository userRepository;
    private final SessionService sessionService;


    public List<String> findAllBeneficiaryEmail () {

        List<String> findAllBeneficiaryByEmail = new ArrayList<>();
        for(Beneficiary beneficiary  : sessionService.sessionUser().getBeneficiaryList()){

            findAllBeneficiaryByEmail.add(beneficiary.getEmail());
        }
        return  findAllBeneficiaryByEmail;

    }



    public User addTransferToBenef(Operation operation) {



       Beneficiary beneficiary = operation.getBeneficiary();

        User user = sessionService.sessionUser();

        Collection<Beneficiary> beneficiaryList = user.getBeneficiaryList();

         for (Beneficiary beneficiary1 : beneficiaryList){
             if(beneficiary1.getName().equals(beneficiary.getName())){

                 beneficiary.setUser(beneficiary1.getUser());
                 beneficiary.setAmount(beneficiary1.getAmount());
                 beneficiary.setName(beneficiary1.getName());
                 beneficiary.setId(beneficiary1.getId());
                 beneficiary.setEmail(beneficiary1.getEmail());

             }
        }



        float amountUser = user.getAccount().getAmount();


        float mtn = operation.getAmount();

        float amountBenef  = beneficiary.getAmount();

        if(amountUser >= mtn) {

            user.getAccount().setAmount(amountUser - mtn);
            beneficiary.setAmount(amountBenef + mtn);
            beneficiaryRepository.save(beneficiary);

            //save operation
            operation.setAccount(user.getAccount());
            operation.setDate(new Date());
            operation.setBeneficiary(beneficiary);

            operationRepository.save(operation);

            return userRepository.save(user);
        }

        return user;
    }
}
