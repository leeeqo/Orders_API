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
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "registration_code")
    private String registrationCode;
    
    @Column(name = "full_name")
    private String fullName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "telephone")
    private String telephone;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL
            , mappedBy = "customer")
    private List<Order> orders;
    
    public Customer() {
    }

    public Customer(String registrationCode, String fullName, String email, String telephone) {
        this.registrationCode = registrationCode;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }
    
    public void addOrderToCustomer(Order order) {
        if (orders == null)
            orders = new ArrayList<>();
        orders.add(order);
        order.setCustomer(this);
    }
    
    public void deleteOrderFromCustomer(Order order) {
        if (orders == null)
            return;
        
        if (!orders.contains(order))
            return;
        
        orders.remove(order);
    }

    public int getId() {
        return id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + 
                ", registrationCode=" + registrationCode + 
                ", fullName=" + fullName + 
                ", email=" + email + 
                ", telephone=" + telephone + 
                '}';
    }
    
    
}
