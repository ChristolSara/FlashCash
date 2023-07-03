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

@Service
@AllArgsConstructor
public class TransferToBenefService {
    private final OperationRepository operationRepository;
    private final BeneficiaryRepository beneficiaryRepository;
    private final UserRepository userRepository;
    private final SessionService sessionService;

    public User addTransferToBenef(Operation operation) {

        User user = sessionService.sessionUser();
        float amountUser = user.getAccount().getAmount();

        float mtn = operation.getAmount();
        Beneficiary beneficiary = operation.getBeneficiary();
        float amountBenef  = beneficiary.getAmount();

        if(amountUser >= mtn) {

            user.getAccount().setAmount(amountUser - mtn);
            beneficiary.setAmount(amountBenef+mtn);
            beneficiaryRepository.save(beneficiary);

            return userRepository.save(user);

        }

        return user;
    }
}
