package fr.greta.FlashCash.models;

import jakarta.persistence.*;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 30)
    private  String swift;
    //@Min(value = 10, message = "amount can not be less than 0")
    private float amount;
    @Size(min = 20, max =34 , message
            = "iban must be between 27 and 34 characters")
    private String iban;
    @OneToOne
    private User user;


    public Account(String cic, int i, String s, User user) {
    }
}
