/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.service;

import com.order.management.entity.Product;
import java.util.List;

/**
 *
 * @author Admin
 */

public interface ProductService {
    public List<Product> getAllProducts();
    
    public void saveProduct(Product product);
    
    public Product getProduct(int id);
    
    public void deleteProduct(int id);
}
