package com.order.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.order.management.repository.OrderLineRepository;
import com.order.management.entity.OrderLine;
import com.order.management.entity.Product;
import com.order.management.entity.Order;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class OrderLineServiceImpl implements OrderLineService {
    
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine getOrderLine(int id) {
        OrderLine orderLine = null;
        Optional<OrderLine> optional = orderLineRepository.findById(id);
        if (optional.isPresent())
            orderLine = optional.get();
        
        return orderLine;
    }
    
    @Override
    public List<OrderLine> getOrderLinesByOrder(Order order) {
        return orderLineRepository.findAllByOrder(order);
    }

    @Override
    public void saveOrderLine(OrderLine orderLine) {
        
        Product product = orderLine.getProduct();
        Order order = orderLine.getOrder();
        
        // This check is necessary if we are not sure that client uses DISTINCT product_id for ONE order
        
        for (OrderLine ol : orderLineRepository.findAllByOrder(order)) {
            if (ol.getProduct().equals(product)) {
                ol.setNumProducts(ol.getNumProducts() + orderLine.getNumProducts());
                return;
            }
        }
        
        product.addOrderLineToProduct(orderLine);
        order.addOrderLineToOrder(orderLine);
        
        orderLineRepository.save(orderLine);
    }

    @Override
    public void deleteOrderLine(int id) {
        orderLineRepository.deleteById(id);
    }
    
}
