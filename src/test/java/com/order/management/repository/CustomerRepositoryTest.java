package com.order.management.repository;

import com.order.management.entity.Customer;
import com.order.management.repository.CustomerRepository;
import java.util.List;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CustomerRepositoryTest {
    
    List<Customer> customers;
    
    @Autowired
    CustomerRepository customerRepository;
    
    public CustomerRepositoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        customers = new ArrayList<>();
        customers.add(new Customer("96874563", "Sybyl Blackster"
                , "sblackster2@cam.ac.uk", "352-436-9721"));
        customers.add(new Customer("1371920", "Gates Harwell"
                , "gharwell3@topsy.com", "938-926-8803"));
        customers.add(new Customer("96049215", "Orelee Spaight"
                , "ospaight4@answers.com", "185-647-0306"));
        customers.add(new Customer("45194056", "Livvy Leemans"
                , "lleemansa@live.com", "399-247-1758"));
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void CustomerRepository_saveAll_ReturnSavedCustomers() {
        
        List<Customer> savedCustomers = customerRepository.saveAll(customers);
                
        Assertions.assertThat(savedCustomers).isNotNull();
        Assertions.assertThat(savedCustomers).allMatch(customer -> customer.getId() > 0);
        Assertions.assertThat(savedCustomers).hasSize(customers.size());
    }
    
}
