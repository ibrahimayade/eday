package com.dreamsoft.account.clients;

import com.dreamsoft.account.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("customers")
    List<Customer> findAll();

    default Customer getDefaultCustomer(Long id, Exception ex) {
        Customer customer = new Customer();
        customer.setEmail("N/A");
        customer.setPhoneNumber("N/A");
        customer.setFirstName("N/A");
        customer.setLastName("N/A");
        customer.setId(id);
        return customer;

    }

}
