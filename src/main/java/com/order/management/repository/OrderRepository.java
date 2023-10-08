package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.Order;
import com.order.management.entity.Customer;
import java.util.List;
import java.sql.Date;



public interface OrderRepository extends JpaRepository<Order, Integer> {
    public List<Order> findAllByCustomer(Customer customer);
    
    public List<Order> findAllBySubmissionDate(Date submissionDate);
}
