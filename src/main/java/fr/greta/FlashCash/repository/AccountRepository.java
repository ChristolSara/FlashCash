package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
