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
import java.util.Optional;
import java.util.List;

import org.springframework.boot.context.config.ConfigDataNotFoundException;

/**
 *
 * @author Admin
 */

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private OrderLineService orderLineService;
    
    @GetMapping("/")
    public List<Order> showAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);
        
        return order;
    }
    
    @PostMapping("/{customer_id}")
    public Order addNewOrder (@PathVariable int customer_id
            , @RequestBody Order order) {
        Order orderToSave = new Order(order.getNumOrderLines()
                , order.getSubmissionDate());
        Customer customerToOrder = customerService.getCustomer(customer_id);
        if (customerToOrder != null)
            orderToSave.setCustomer(customerToOrder);
        
        orderService.saveOrder(orderToSave);
        
        return order;
    }
    
    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        
        return order;
    }
    
    @PutMapping("/{id}/{product_id}/{num_products}")
    public Order updateNumProductsInOrder(@PathVariable int id
            , @PathVariable int product_id
            , @PathVariable int num_products) {
        Order order = orderService.getOrder(id);
        Product product = productService.getProduct(product_id);
        
        List<OrderLine> orderLinesByOrder = orderLineService.getOrderLinesByOrder(order);
        for (OrderLine orderLine : orderLinesByOrder) {
            if (orderLine.getProduct().equals(product)) {
                orderLine.setNumProducts(num_products);
            }
        }
        
        return order;
    }
    
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);
        orderService.deleteOrder(id);
        
        return "Order with ID = " + id + " was deleted.";
    }
    
    @GetMapping("/product/{product_id}")
    public List<Order> getOrdersByProduct(@PathVariable int product_id) {
        Product product = productService.getProduct(product_id);
        List<Order> orders = orderService.findAllByProduct(product);
        
        return orders;
    }
    
    @GetMapping("/customer/{customer_id}")
    public List<Order> getOrdersByCustomer(@PathVariable int customer_id) {
        Customer customer = customerService.getCustomer(customer_id);
        List<Order> orders = orderService.findAllByCustomer(customer);
        
        return orders;
    }
}
