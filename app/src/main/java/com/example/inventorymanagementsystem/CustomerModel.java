package com.example.inventorymanagementsystem;

public class CustomerModel {

    String customerName , contact , email , curl;

    CustomerModel(){

    }


    public CustomerModel(String customerName, String contact, String email, String curl) {
        this.customerName = customerName;
        this.contact = contact;
        this.email = email;
        this.curl = curl;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }
}
