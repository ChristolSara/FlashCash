package fr.greta.FlashCash.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "firstname is mandatory")
    private String firstName;
    @NotBlank(message = "lastname is mandatory")
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @NotBlank(message = "phone is mandatory")
    private String phone;
    @NotBlank(message = "adress is mandatory")
    private String adress;
    @Column(unique = true)
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    @OneToOne
    private  Account account;
    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    private List<beneficiary> beneficiaryList;

}
