package fr.greta.FlashCash.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private Date date;
    private float amount;
    @ManyToOne
    private Account account;
    @ManyToOne
    private beneficiary beneficiary;


}
