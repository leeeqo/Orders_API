package com.order.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name = "order_lines")
public class OrderLine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
    
    @Column(name = "num_products")
    private int numProducts;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    public OrderLine() {
    }

    public OrderLine(int numProducts) {
        this.numProducts = numProducts;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumProducts() {
        return numProducts;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" + 
                "id=" + id + 
                ", product=" + product + 
                ", numProducts=" + numProducts + 
                ", order=" + order + 
                '}';
    }

    
    
    
}
