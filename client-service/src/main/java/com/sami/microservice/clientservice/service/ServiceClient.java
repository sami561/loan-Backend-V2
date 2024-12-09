package com.sami.microservice.clientservice.service;

import com.sami.microservice.clientservice.entities.Client;
import com.sami.microservice.clientservice.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceClient implements IServiceClient {
    public  ClientRepository clientRepository;
    @Override
    public Client createClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client findClientById(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
