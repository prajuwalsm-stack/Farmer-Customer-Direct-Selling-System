package com.farmdirect.model;
public class User {
    private int id; private String name,email,phone,address,role;
    public User(int id,String name,String email,String phone,String address,String role){this.id=id;this.name=name;this.email=email;this.phone=phone;this.address=address;this.role=role;}
    public int getId(){return id;} public String getName(){return name;} public String getEmail(){return email;}
    public String getPhone(){return phone;} public String getAddress(){return address;} public String getRole(){return role;}
}