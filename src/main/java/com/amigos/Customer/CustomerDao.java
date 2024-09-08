package com.amigos.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> selectAllCustomer();
    List<Customer> selectCustomerById();

}
