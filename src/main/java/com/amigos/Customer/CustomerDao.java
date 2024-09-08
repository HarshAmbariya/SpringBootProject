package com.amigos.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomer();
    Optional<Customer> selectCustomerById(int id);

}
