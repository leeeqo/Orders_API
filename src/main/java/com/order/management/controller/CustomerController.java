package com.order.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.order.management.service.CustomerService;
import com.order.management.entity.Customer;

import java.util.List;



@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public List<Customer> showAllCustomer() {
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }
    
    @PostMapping
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        
        return customer;
    }
    
    @PostMapping("/all")
    public Customer[] addNewCustomers(@RequestBody Customer[] customers) {
        for (Customer customer : customers) {
            customerService.saveCustomer(customer);
        }
        
        return customers;
    }
    
    @DeleteMapping
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
