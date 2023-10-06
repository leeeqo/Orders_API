/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.OrderLine;
import com.order.management.entity.Product;
import com.order.management.entity.Order;
import java.util.List;

/**
 *
 * @author Admin
 */

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    public List<OrderLine> findAllByProduct(Product product);
    
    public List<OrderLine> findAllByOrder(Order order);
}
