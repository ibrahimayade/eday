package com.dreamsoft.account.web;

import com.dreamsoft.account.clients.CustomerRestClient;
import com.dreamsoft.account.entites.Account;
import com.dreamsoft.account.models.Customer;
import com.dreamsoft.account.utils.ServletRequestUtil;
import com.dreamsoft.account.repositories.AccountRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    public Account getCustomerById(HttpServletRequest request, @PathVariable String id){

        Account account= accountRepository.findById(id).orElseThrow(null);
        final HttpHeaders headers=ServletRequestUtil.getHeaders(request);
        Customer customer=customerRestClient.findCustomerById(headers,account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }


    private HttpHeaders getHeaders(final HttpServletRequest httpServletRequest) {
        var iterator = httpServletRequest.getHeaderNames().asIterator();
        final HttpHeaders headers = new HttpHeaders();
        while (iterator.hasNext()) {
            var key = iterator.next();
            headers.add(key, httpServletRequest.getHeader(key));
        }
        return headers;
    }


}
