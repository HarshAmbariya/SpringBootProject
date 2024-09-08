package com.amigos.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CustomerController {

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("api/v1/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        Customer customer= customers.stream()
                .filter(c->c.id. equals(customerId))
                .findFirst()
                .orElseThrow(
                        ()->new IllegalArgumentException("customers with id[%s] not found".formatted(customerId)));
        return customer;

    }
}
