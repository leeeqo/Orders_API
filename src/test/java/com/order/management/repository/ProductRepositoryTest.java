package com.order.management.repository;

import com.order.management.repository.ProductRepository;
import com.order.management.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductRepositoryTest {
    
    List<Product> products;
   
    @Autowired
    ProductRepository productRepository;
    
    public ProductRepositoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        products = new ArrayList<>();
        products.add(new Product("Muffin Chocolate"
                , "488LS71Y8", 10));
        products.add(new Product("Crab - Pink, Frozen"
                , "003UO92B8", 59));
        products.add(new Product("Potatoes - Idaho 10 Count"
                , "847AT75L4", 10));
    }
    
    @AfterEach
    public void tearDown() {
        for (Product product : products) {
            productRepository.delete(product);
        }
    }
    
    @Test
    public void ProductRepository_saveAll_ReturnSavedProducts() {
        
        List<Product> savedProducts = productRepository.saveAll(products);
                
        Assertions.assertThat(savedProducts).isNotNull();
        Assertions.assertThat(savedProducts).allMatch(product -> product.getId() > 0);
        Assertions.assertThat(savedProducts).hasSize(products.size());
    }
    
    @Test
    public void ProductRepository_getAll_ReturnSavedProducts() {
        
        productRepository.saveAll(products);
        List<Product> foundProducts = productRepository.findAll();
                
        Assertions.assertThat(foundProducts).isNotNull();
        Assertions.assertThat(foundProducts).allMatch(product -> product.getId() > 0);
    }
    
}
