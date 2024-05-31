package com.dreamsoft.account.clients;

import com.dreamsoft.account.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE"/*,url = "http://localhost:8081", path = "/customer-service"*/)
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    //@CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@RequestHeader HttpHeaders headers, @PathVariable Long id);

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
