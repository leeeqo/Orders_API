/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.utils;

import org.springframework.beans.factory.annotation.Autowired;
import com.order.management.dao.OrderLineRepository;
import com.order.management.dao.CustomerRepository;
import com.order.management.dao.ProductRepository;
import com.order.management.entity.Order;
import com.order.management.dto.OrderSummary;
import com.order.management.dto.OrderCreation;
import com.order.management.entity.Product;
import com.order.management.entity.Customer;
import com.order.management.entity.OrderLine;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class MappingUtils {
    
    @Autowired
    OrderLineRepository orderLineRepository;
    
    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    
    public OrderSummary orderToSummary(Order order) {
        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumOrderLines(order.getNumOrderLines());
        orderSummary.setCustomerFullName(order.getCustomer().getFullName());
        
        String[] productNames = new String[order.getNumOrderLines()];
        int[] productNums = new int[order.getNumOrderLines()];
        List<OrderLine> orderLines = orderLineRepository.findAllByOrder(order);
        for (int i = 0; i < order.getNumOrderLines(); i++) {
            productNames[i] = orderLines.get(i).getProduct().getName();
            productNums[i] = orderLines.get(i).getNumProducts();
        }
        
        orderSummary.setProductNames(productNames);
        orderSummary.setProductNums(productNums);
        orderSummary.setSubmissionDate(order.getSubmissionDate());
        
        return orderSummary;
    }
    
    public Order orderCreationToOrder(OrderCreation orderCreation) {
        Order order = new Order();
        //order.setNumOrderLines(orderCreation.getNumOrderLines());
        
        Optional<Customer> optional = customerRepository.findById(orderCreation.getCustomerId());
        if (optional.isPresent())
            order.setCustomer(optional.get());
        
        order.setSubmissionDate(orderCreation.getSubmissionDate());
        
        return order;
    }
    
    public List<OrderLine> orderCreationToOrderLines(OrderCreation orderCreation) {
        
        List<OrderLine> orderLines = new ArrayList<>();
        int[] productIds = orderCreation.getProductIds();
        int[] productNums = orderCreation.getProductNums();
        
        Optional<Product> optional = null;
        for (int i = 0; i < productIds.length; i++) {
            int product_id = productIds[i];
            optional = productRepository.findById(product_id);
            if (optional.isPresent()) {
                OrderLine orderLine = new OrderLine(productNums[i]);
                orderLine.setProduct(optional.get());
                
                orderLines.add(orderLine);
            }
        }
        
        return orderLines;
    }
}
