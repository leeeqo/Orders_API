/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.order.management.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "sku_code")
    private String skuCode;
    
    @Column(name = "unit_price")
    private int unitPrice;
    
    @OneToMany(fetch = FetchType.EAGER
            , cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH}
            , mappedBy = "product")
    private List<OrderLine> orderLines;
    
    public Product() {}
    
    public void addOrderLineToProduct(OrderLine orderLine) {
        if (orderLines == null)
            orderLines = new ArrayList<>();
        orderLines.add(orderLine);
        //orderLine.setProduct(this);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSkuCode() {
        return skuCode;
    }
    
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    
    public int getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", skuCode='" + skuCode + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
