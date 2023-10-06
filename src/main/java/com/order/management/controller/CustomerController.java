/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.order.management.service.ProductService;
import com.order.management.service.OrderService;
import com.order.management.service.CustomerService;
import com.order.management.service.OrderLineService;
import com.order.management.entity.Order;
import com.order.management.entity.Product;
import com.order.management.entity.Customer;
import com.order.management.entity.OrderLine;
import java.util.List;

/**
 *
 * @author Admin
 */

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
    
    @DeleteMapping
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
