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

import com.order.management.utils.MappingUtils;
import java.util.stream.Collectors;
import com.order.management.dto.OrderSummary;
import com.order.management.dto.OrderCreation;
import java.util.Arrays;

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
    
    @Autowired
    private MappingUtils mappingUtils;
    
    /*@GetMapping("/")
    public List<Order> showAllOrders() {
        return orderService.getAllOrders();
    }*/
    
    @GetMapping
    public List<OrderSummary> showAllOrders() {
        return orderService.getAllOrders().stream()
                .map(mappingUtils::orderToSummary)
                .collect(Collectors.toList());
    }
    
    /*@GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);
        
        return order;
    }*/
    
    @GetMapping("/{id}")
    public OrderSummary getOrder(@PathVariable int id) {
        Order order = orderService.getOrder(id);
        
        return mappingUtils.orderToSummary(order);
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
    
    /*@PostMapping("/{customer_id}")
    public Order addNewOrder (@PathVariable int customer_id
            , @RequestBody Order order) {
        Order orderToSave = new Order(0
                , order.getSubmissionDate());
        Customer customerToOrder = customerService.getCustomer(customer_id);
        if (customerToOrder != null)
            orderToSave.setCustomer(customerToOrder);
        
        orderService.saveOrder(orderToSave);
        
        return order;
    }*/
    
    @PostMapping
    public Order addNewOrder(@RequestBody OrderCreation orderCreation) {
        Order order = mappingUtils.orderCreationToOrder(orderCreation);
        orderService.saveOrder(order);
        
        List<OrderLine> orderLines = mappingUtils.orderCreationToOrderLines(orderCreation);
        for (OrderLine orderLine : orderLines) {
            orderLine.setOrder(order);
            orderLineService.saveOrderLine(orderLine);
        }
        
        return order;
    }
    
    @PostMapping("/all")
    public Order[] addNewOrder(@RequestBody OrderCreation[] orderCreation) {
        
        Order[] orders = Arrays.stream(orderCreation)
                .map(mappingUtils::orderCreationToOrder)
                .toArray(Order[]::new);
        
        for (int i = 0; i < orderCreation.length; i++) {
            orderService.saveOrder(orders[i]);
            
            List<OrderLine> orderLines = mappingUtils.orderCreationToOrderLines(orderCreation[i]);
            for (OrderLine orderLine : orderLines) {
                orderLine.setOrder(orders[i]);
                orderLineService.saveOrderLine(orderLine);
            }
        }
        
        return orders;
    }
    
    /*@PutMapping
    public Order updateOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        
        return order;
    }*/
    
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
}
