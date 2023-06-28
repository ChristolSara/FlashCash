package fr.greta.FlashCash.service;

import fr.greta.FlashCash.repository.OperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferToBankService {
    private final OperationRepository operationRepository;
}
