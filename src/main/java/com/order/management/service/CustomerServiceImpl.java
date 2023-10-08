package com.order.management.service;

import com.order.management.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import com.order.management.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent())
            customer = optional.get();
        
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
    
}
