package com.order.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.order.management.entity.Product;
import com.order.management.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        Product product = null;
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent())
            product = optional.get();
        
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
    
}
