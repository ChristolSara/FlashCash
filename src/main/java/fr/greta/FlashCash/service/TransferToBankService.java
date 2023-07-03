package fr.greta.FlashCash.service;

import fr.greta.FlashCash.models.Account;
import fr.greta.FlashCash.models.Operation;
import fr.greta.FlashCash.models.User;
import fr.greta.FlashCash.repository.OperationRepository;
import fr.greta.FlashCash.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferToBankService {
    private final OperationRepository operationRepository;
    private final UserRepository userRepository;
    private final SessionService sessionService;


    public User addTransferToBank(Operation operation) {

        User user = sessionService.sessionUser();
        Account account = user.getAccount();

        float amountUser = account.getAmount();
        float amount = operation.getAmount();

        if(amountUser >= amount) {

            user.getAccount().setAmount(amountUser - amount);
            return userRepository.save(user);

        }
        return user;

    }
}
