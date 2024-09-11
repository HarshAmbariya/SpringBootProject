package com.amigos.Customer;

import com.amigos.exception.DuplicateResourceException;
import com.amigos.exception.ResourseNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomer();
    }
    public Customer getCustomer(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourseNotFound("Customer with id [%s] not found".formatted(id)));
    }
    public void addCustomer(
            CustomerRegestrationRequest customerRegestrationRequest){
        if(customerDao.existsPersonWithEmail(customerRegestrationRequest.email()))
            throw new DuplicateResourceException("Email address already in use");

        customerDao.insertCustomer(new Customer(customerRegestrationRequest.name(),
                customerRegestrationRequest.age(),
                customerRegestrationRequest.email()));
    }
}