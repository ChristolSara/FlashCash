package fr.greta.FlashCash.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
