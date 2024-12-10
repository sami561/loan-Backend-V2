package com.sami.microservice.appointementservice.Model;

import java.beans.Transient;

public class Agency {


    private int id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private int governoratId;


    // No-argument constructor
    public Agency() {
    }

    // All-arguments constructor
    public Agency(int id, String name, String address, String contactNumber, String email, int governoratId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.governoratId = governoratId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGovernoratId() {
        return governoratId;
    }

    public void setGovernoratId(int governoratId) {
        this.governoratId = governoratId;
    }



    // toString method for better readability (optional)
    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", governoratId=" + governoratId +
                '}';
    }
}