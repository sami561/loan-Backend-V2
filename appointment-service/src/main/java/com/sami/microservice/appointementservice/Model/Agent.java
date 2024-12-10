package com.sami.microservice.appointementservice.Model;


public class Agent {
    private int id;
    private String name;
    private String contactNumber;
    private String email;
    private String position;

    // No-args constructor
    public Agent() {
    }

    // All-args constructor
    public Agent(int id, String name, String contactNumber, String email, String position) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // toString method
    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    // Optionally: equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        return id == agent.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
