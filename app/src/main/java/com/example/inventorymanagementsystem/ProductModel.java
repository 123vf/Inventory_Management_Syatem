package com.example.inventorymanagementsystem;

public class ProductModel {

    String name , price ,quantity , discription , purl;

    ProductModel(){

    }

    public ProductModel(String name, String price, String quantity, String discription, String purl) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discription = discription;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
