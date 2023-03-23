package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
    @Id
    private String id;

    private String username;

    private String name;

    private String address;

    private boolean active;

    public Customer(){
        //  Default constructor
    }

    public Customer(String username, String name, String address, boolean active){
        this.username = username;
        this.name = name;
        this.address = address;
        this.active = active;
    }//  Parameterized constructor

    //  GETTERS and SETTERS
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}// END CLASS
