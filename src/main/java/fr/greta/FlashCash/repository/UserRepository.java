package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.Beneficiary;
import fr.greta.FlashCash.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {


   public Optional<User> findUserByEmail(String s);

}
