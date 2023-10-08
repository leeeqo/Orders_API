package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.OrderLine;
import com.order.management.entity.Product;
import com.order.management.entity.Order;
import java.util.List;



public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    public List<OrderLine> findAllByProduct(Product product);
    
    public List<OrderLine> findAllByOrder(Order order);
}
