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
@RequestMapping("/orderlines")
public class OrderLineController {
    
    @Autowired
    private OrderLineService orderLineService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<OrderLine> showAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }
    
    @GetMapping("/{id}")
    public OrderLine showAllOrderLines(@PathVariable int id) {
        return orderLineService.getOrderLine(id);
    }
    
    @PostMapping("/{order_id}/{product_id}")
    public OrderLine addNewOrderLine(@PathVariable int order_id
            , @PathVariable int product_id
            , @RequestBody OrderLine orderLine) {
        //orderLineService.saveOrderLine(orderLine);
        
        OrderLine orderLineToSave = new OrderLine(orderLine.getNumProducts());
        
        Product productToOrderLine = productService.getProduct(product_id);
        if (productToOrderLine != null)
            orderLineToSave.setProduct(productToOrderLine);
        
        Order orderToOrderLine = orderService.getOrder(order_id);
        if (orderToOrderLine != null)
            orderLineToSave.setOrder(orderToOrderLine);
        
        orderLineService.saveOrderLine(orderLineToSave);
        
        return orderLine;
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrderLine(@PathVariable int id) {
        orderLineService.deleteOrderLine(id);
    }
}
