package com.amigos;

import com.amigos.Customer.Customer;
import com.amigos.Customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer alex = new Customer("Alex", 31, "alex@gmail.com");
            Customer jamila = new Customer("Jamila", 21, "jamila@gmail.com");
            List<Customer> customers = List.of(alex, jamila);
            customerRepository.saveAll(customers);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
