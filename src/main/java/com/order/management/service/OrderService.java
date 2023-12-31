package com.order.management.service;

import com.order.management.entity.Product;
import com.order.management.entity.Order;
import com.order.management.entity.Customer;
import java.util.List;
import java.sql.Date;



public interface OrderService {
    public List<Order> getAllOrders();
    
    public Order getOrder(int id);
    
    public void saveOrder(Order order);
    
    public void deleteOrder(int id);
    
    public List<Order> findAllByProduct(Product product);
    
    public List<Order> findAllByCustomer(Customer customer);
    
    public List<Order> findAllBySubmissionDate(Date date);
}
