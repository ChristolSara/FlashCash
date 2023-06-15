package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Integer> {
}
