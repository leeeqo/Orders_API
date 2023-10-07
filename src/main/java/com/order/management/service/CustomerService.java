/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.service;

import com.order.management.entity.Customer;
import java.util.List;

/**
 *
 * @author Admin
 */

public interface CustomerService {
    public List<Customer> getAllCustomers();
    
    public void saveCustomer(Customer customer);
    
    public Customer getCustomer(int id);
    
    public void deleteCustomer(int id);
}
