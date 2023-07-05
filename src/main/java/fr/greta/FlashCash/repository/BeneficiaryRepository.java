package fr.greta.FlashCash.repository;

import fr.greta.FlashCash.models.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Integer> {



    Beneficiary findBeneficiaryByEmail (String email);

}
