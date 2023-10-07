/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.order.management.service.ProductService;
import com.order.management.entity.Product;

import java.util.List;

/**
 *
 * @author Admin
 */

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> showAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }
    
    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        
        return product;
    }
    
    @PostMapping("/all")
    public Product[] addNewProducts(@RequestBody Product[] products) {
        for (Product product : products) {
            productService.saveProduct(product);
        }
        
        return products;
    }
    
    /*@PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        
        return product;
    }*/
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
