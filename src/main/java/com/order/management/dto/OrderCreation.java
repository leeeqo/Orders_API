package com.order.management.dto;

import java.sql.Date;



public class OrderCreation {
    //private int numOrderLines;
    private int customerId;
    private int[] productIds;
    private int[] productNums;
    private Date submissionDate;
    
    public OrderCreation() {};

//    public int getNumOrderLines() {
//        return numOrderLines;
//    }

    public int getCustomerId() {
        return customerId;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public int[] getProductNums() {
        return productNums;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

//    public void setNumOrderLines(int numOrderLines) {
//        this.numOrderLines = numOrderLines;
//    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }

    public void setProductNums(int[] productNums) {
        this.productNums = productNums;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "OrderCreation{" + 
                //"numOrderLines=" + numOrderLines + 
                ", customerId=" + customerId + 
                ", productIds=" + productIds + 
                ", productNums=" + productNums + 
                ", submissionDate=" + submissionDate + 
                '}';
    }

    
}
