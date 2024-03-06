package com.dreamsoft.account;

import com.dreamsoft.account.entites.Account;
import com.dreamsoft.account.enums.AccountType;
import com.dreamsoft.account.enums.Currency;
import com.dreamsoft.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {
            List<Account> accounts = List.of(
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .currency(Currency.XOF)
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .balance(500000.0)
                            .customerId(1L)
                            .createdAt(LocalDate.now())
                            .build(),
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .currency(Currency.XOF)
                            .accountType(AccountType.SAVING_ACCOUNT)
                            .balance(200000.0)
                            .customerId(2L)
                            .createdAt(LocalDate.now())
                            .build(),
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .currency(Currency.XOF)
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .balance(300000.0)
                            .customerId(3L)
                            .createdAt(LocalDate.now())
                            .build(),
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .currency(Currency.XOF)
                            .accountType(AccountType.SAVING_ACCOUNT)
                            .balance(3400.0)
                            .customerId(1L)
                            .createdAt(LocalDate.now())
                            .build()


            );
            accountRepository.saveAll(accounts);

        };
    }
}
