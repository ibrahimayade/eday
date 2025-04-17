package com.dreamsoft.account.entites;

import com.dreamsoft.account.enums.AccountType;
import com.dreamsoft.account.enums.Currency;
import com.dreamsoft.account.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate createdAt;

    private Double balance;
    @Enumerated(EnumType.STRING)
    private Currency currency;

   @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customerId;

    @Transient
    private Customer customer;
}
