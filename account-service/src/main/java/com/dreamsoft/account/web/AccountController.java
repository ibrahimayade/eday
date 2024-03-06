package com.dreamsoft.account.web;

import com.dreamsoft.account.clients.CustomerRestClient;
import com.dreamsoft.account.entites.Account;
import com.dreamsoft.account.models.Customer;
import com.dreamsoft.account.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("")
    public List<Account> getAccounts(){
        return  accountRepository.findAll();
    }
    @GetMapping("/{id}")
    public Account getCustomerById(@PathVariable String id){
        Account account= accountRepository.findById(id).orElseThrow(null);
        Customer customer=customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
