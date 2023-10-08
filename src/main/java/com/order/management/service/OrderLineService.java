package com.order.management.service;

import com.order.management.entity.OrderLine;
import com.order.management.entity.Order;
import java.util.List;



public interface OrderLineService {
    public List<OrderLine> getAllOrderLines();
    
    public OrderLine getOrderLine(int id);
    
    public List<OrderLine> getOrderLinesByOrder(Order order);
    
    public void saveOrderLine(OrderLine orderLine);
    
    public void deleteOrderLine(int id);
}
