package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Integer> {

}
