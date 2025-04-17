package com.dreamsoft.customer.web;


import com.dreamsoft.customer.entities.Customer;
import com.dreamsoft.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private  final CustomerRepository customerRepository;

    @GetMapping("")
    public List<Customer> getCustomers(){
       return  customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer getAccountById(@PathVariable Long id){
        return  customerRepository.findById(id).orElseThrow(null);
    }

}
