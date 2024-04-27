package com.example.cpp.service;

import com.example.cpp.model.Client;
import com.example.cpp.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ClientService {

    public ClientService() {
    }

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepo.findById(id).get();
    }

    public void saveClient(Client client) {
        clientRepo.save(client);
    }
    public void saveClients (List<Client> clients) {
        for(Client client : clients) clientRepo.save(client);
    }

    public void updateClient(Client client){
        clientRepo.updateClient(client);
    }

    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
    /*public void updateClient(Client client){
        clientRepo.
    }*/

    // Autres méthodes de service personnalisées si nécessaire
}
