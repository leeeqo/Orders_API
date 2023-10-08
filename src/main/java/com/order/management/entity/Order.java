package com.order.management.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "num_order_lines")
    private int numOrderLines;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    
    @Column(name = "submission_date")
    private Date submissionDate;
    
    @OneToMany(fetch = FetchType.EAGER 
            , cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH}
            , mappedBy = "order")
    private List<OrderLine> orderLines;

    
    public Order() {}

    public Order(int numOrderLines, Date submissionDate) {
        this.numOrderLines = numOrderLines;
        this.submissionDate = submissionDate;
    }
    
    public void addOrderLineToOrder(OrderLine orderLine) {
        if (orderLines == null)
            orderLines = new ArrayList<>();
        
        orderLines.add(orderLine);
        numOrderLines++;
    }

    public int getId() {
        return id;
    }

    public int getNumOrderLines() {
        return numOrderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumOrderLines(int numOrderLines) {
        this.numOrderLines = numOrderLines;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "Order{" + 
                "id=" + id + 
                ", numOrderLines=" + numOrderLines + 
                ", customer=" + customer + 
                ", submissionDate=" + submissionDate + 
                '}';
    }
    
    
}
