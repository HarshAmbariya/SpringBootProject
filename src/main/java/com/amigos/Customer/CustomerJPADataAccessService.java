package com.amigos.Customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class CustomerJPADataAccessService implements CustomerDao{

    private  final  CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }
}
