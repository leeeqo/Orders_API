package com.order.management.dto;

import java.sql.Date;



public class OrderSummary {
    private int id;
    private int numOrderLines;
    private String customerFullName;
    private String[] productNames;
    private int[] productNums;
    private Date submissionDate;
    
    public OrderSummary() {};

    public int getId() {
        return id;
    }

    public int getNumOrderLines() {
        return numOrderLines;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String[] getProductNames() {
        return productNames;
    }
    
    public int[] getProductNums() {
        return productNums;
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

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }
    
    public void setProductNums(int[] productNums) {
        this.productNums = productNums;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "OrderSummary{" + 
                "id=" + id + 
                ", numOrderLines=" + numOrderLines + 
                ", customerFullName=" + customerFullName + 
                ", productNames=" + productNames + 
                ", productNums=" + productNums + 
                ", submissionDate=" + submissionDate + 
                '}';
    }

  
}
