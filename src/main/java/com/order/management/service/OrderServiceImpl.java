package com.order.management.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.management.entity.Order;
import com.order.management.repository.OrderRepository;
import com.order.management.repository.OrderLineRepository;
import com.order.management.entity.Product;
import com.order.management.entity.OrderLine;
import com.order.management.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderLineRepository orderLineRepository;
    
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        Customer customer = order.getCustomer();
        customer.addOrderToCustomer(order);
        
        orderRepository.save(order);   
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent())
            order = optional.get();
        
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAllByProduct(Product product) {
        List<OrderLine> orderLinesByProduct =
                orderLineRepository.findAllByProduct(product);
        
        List<Order> ordersByProduct = new ArrayList<>();
        for (OrderLine orderLine : orderLinesByProduct) {
            Order order = orderLine.getOrder();
            ordersByProduct.add(order);
        }
       
        return ordersByProduct;
    }
    
    @Override
    public List<Order> findAllByCustomer(Customer customer) {
        List<Order> ordersByCustomer = 
                orderRepository.findAllByCustomer(customer);
        
        return ordersByCustomer;
    }
    
    @Override
    public List<Order> findAllBySubmissionDate(Date date) {
        List<Order> ordersByDate = 
                orderRepository.findAllBySubmissionDate(date);
        
        return ordersByDate;
    }
}
