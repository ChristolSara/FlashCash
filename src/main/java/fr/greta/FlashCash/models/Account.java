package fr.greta.FlashCash.models;

import jakarta.persistence.*;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String swift;
    private float amount;
    private String iban;
    @OneToOne
    private User user;


}
