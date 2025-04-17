package com.dreamsoft.customer;

import com.dreamsoft.customer.config.GlobalConfig;
import com.dreamsoft.customer.entities.Customer;
import com.dreamsoft.customer.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(Customer.builder().
                    firstName("Ibrahima").
                    lastName("YADE").
                    email("yad.ibrahim@gmail.com")
                    .phoneNumber("+221775972243").build(),
            Customer.builder().
                    firstName("Samba").
                    lastName("SIDIBE").
                    email("ssidibe@gmail.com")
                    .phoneNumber("+221775536114").build(),
            Customer.builder().
                    firstName("Alioune").
                    lastName("DIA").
                    email("dia.alioune@gmail.com")
                    .phoneNumber("+221775191467").build());
            customerRepository.saveAll(customers);

        };
    }
}
