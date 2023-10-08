package com.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.management.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
