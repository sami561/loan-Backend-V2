package com.sami.microservice.clientservice.service;



import com.sami.microservice.clientservice.entities.Client;

import java.util.List;

public interface IServiceClient {
    public Client createClient(Client c);
    public  Client findClientById(int id);
    public List<Client> findAllClient();
    public Client updateClient(Client c);
    public void deleteClient(int id);
}
