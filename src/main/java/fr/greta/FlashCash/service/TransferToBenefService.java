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



    public Operation addTransferToBenef(Operation operation) {
        User user = sessionService.sessionUser();
        Beneficiary beneficiary= operation.getBeneficiary();


        operation.setAccount(user.getAccount());
        operation.setDate(new Date());


        float mtn = (user.getAccount().getAmount() )- (operation.getAmount());
        user.getAccount().setAmount(mtn);
        beneficiary.setAmount(beneficiary.getAmount() + operation.getAmount());

        userRepository.save(user);
        beneficiaryRepository.save(beneficiary);
      return   operationRepository.save(operation);




    }
}
