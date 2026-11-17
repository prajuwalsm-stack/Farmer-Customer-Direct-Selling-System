package com.farmdirect.model;
public class Product {
    private int id,farmerId,stock; private String name,category,description,farmerName; private double price;
    public Product(int id,int farmerId,String name,String category,double price,int stock,String description,String farmerName){this.id=id;this.farmerId=farmerId;this.name=name;this.category=category;this.price=price;this.stock=stock;this.description=description;this.farmerName=farmerName;}
    public int getId(){return id;} public int getFarmerId(){return farmerId;} public String getName(){return name;} public String getCategory(){return category;}
    public double getPrice(){return price;} public int getStock(){return stock;} public String getDescription(){return description;} public String getFarmerName(){return farmerName;}
}