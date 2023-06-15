package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
