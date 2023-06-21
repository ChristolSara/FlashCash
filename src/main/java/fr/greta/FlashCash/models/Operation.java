package fr.greta.FlashCash.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Date date;
    private float amount;
    @ManyToOne
    private Account account;
    @ManyToOne
    private beneficiary beneficiary;


}
