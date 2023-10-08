package com.order.management.service;

import com.order.management.entity.Product;
import java.util.List;



public interface ProductService {
    public List<Product> getAllProducts();
    
    public void saveProduct(Product product);
    
    public Product getProduct(int id);
    
    public void deleteProduct(int id);
}
