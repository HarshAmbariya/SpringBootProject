package com.amigos.Customer;

import java.util.ArrayList;
import java.util.List;



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
}
