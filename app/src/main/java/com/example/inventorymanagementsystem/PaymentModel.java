package com.example.inventorymanagementsystem;

public class PaymentModel {

    String productName , customerName ;
    String totalAmount;

    PaymentModel(){

    }

    public PaymentModel(String productName, String customerName, String totalAmount) {
        this.productName = productName;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
