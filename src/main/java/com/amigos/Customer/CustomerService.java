package com.amigos.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getLLCustomers() {
       return customerDao.selectAllCustomer();
    }
    public Customer getCustomers(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "customer with id [%s] not found".formatted(id)));
    }


}
