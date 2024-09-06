package com.amigos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@SpringBootApplication
public class Main {
    private static List <Customer> customers;
    static{
        customers = new ArrayList<>();
        Customer alex = new Customer("alex",21,1,"xyz@gmail.com");
        customers.add(alex);
        Customer jamila = new Customer("jamila",22,6,"xhz@gmail.com");
        customers.add(jamila);
    }


    public static void main(String[] args) {

        SpringApplication.run(Main.class , args);
     }
     @GetMapping("api/v1/customers")
     public List<Customer> getCustomers() {
        return customers;
     }

     @GetMapping("api/v1/customers/{customerId}")
     public Customer getCustomer(@PathVariable("customerId") Integer customerId){
         Customer customer= customers.stream()
                 .filter(c->c.id.equals(customerId))
                 .findFirst()
                 .orElseThrow(
                         ()->new IllegalArgumentException("customers with id[%s] not found".formatted(customerId)));
         return customer;

     }

     static  class Customer {
        private String name;
        private Integer age;

        private Integer id;
        private String email;
        public Customer() {}


         public Customer(String name, Integer age, Integer id, String email) {
             this.name = name;
             this.age = age;
             this.id = id;
             this.email = email;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getEmail() {
             return email;
         }

         public void setEmail(String email) {
             this.email = email;
         }

         public Integer getId() {
             return id;
         }

         public void setId(Integer id) {
             this.id = id;
         }

         public Integer getAge() {
             return age;
         }

         public void setAge(Integer age) {
             this.age = age;
         }
         public String toString() {
             return "Customer{" +
                     "name='" + name + '\'' +
                     ", age=" + age +
                     ", id=" + id +
                     ", email='" + email + '\'' +
                     '}';
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Customer customer = (Customer) o;
             return Objects.equals(name, customer.name) && Objects.equals(age, customer.age) && Objects.equals(id, customer.id) && Objects.equals(email, customer.email);
         }

         @Override
         public int hashCode() {
             return Objects.hash(name, age, id, email);
         }
     }


}
