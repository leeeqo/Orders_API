/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.Customer;

/**
 *
 * @author Admin
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
