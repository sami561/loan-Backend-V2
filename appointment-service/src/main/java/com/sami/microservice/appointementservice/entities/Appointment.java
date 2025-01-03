package com.sami.microservice.appointementservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sami.microservice.appointementservice.Model.Agency;
import com.sami.microservice.appointementservice.Model.Agent;
import com.sami.microservice.appointementservice.Model.Client;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;

    private String status;

    @Transient
    private Agent agent;
    private int agentId;

    @Transient
    private Agency agency;
    private int agencyId;

    @Transient
    private Client client;
    private int clientId;

    // No-args constructor
    public Appointment() {
    }

    // All-args constructor
    public Appointment(int id, LocalDateTime dateRdv, String status, int agentId, int agencyId, int clientId) {
        this.id = id;
        this.dateRdv = dateRdv;
        this.status = status;
        this.agentId = agentId;
        this.agencyId = agencyId;
        this.clientId = clientId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(LocalDateTime dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    // toString method
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", dateRdv=" + dateRdv +
                ", status='" + status + '\'' +
                ", agentId=" + agentId +
                ", agencyId=" + agencyId +
                ", clientId=" + clientId +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
