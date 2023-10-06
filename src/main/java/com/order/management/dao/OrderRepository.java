/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.Order;
import com.order.management.entity.Customer;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Admin
 */


public interface OrderRepository extends JpaRepository<Order, Integer> {
    public List<Order> findAllByCustomer(Customer customer);
    
    public List<Order> findAllBySubmissionDate(Date submissionDate);
}
