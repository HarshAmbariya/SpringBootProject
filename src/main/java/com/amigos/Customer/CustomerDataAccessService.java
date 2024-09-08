package com.amigos.Customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao{
    private static List <Customer> customers;
    static{
        customers = new ArrayList<>();
        Customer alex = new Customer("alex",21,1,"xyz@gmail.com");
        customers.add(alex);
        Customer jamila = new Customer("jamila",22,6,"xhz@gmail.com");
        customers.add(jamila);
    }
    @Override
    public List<Customer> selectAllCustomer() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c->c.getId().equals(id))
                .findFirst();


    }
}