package com.example.cpp.service;

import com.example.cpp.model.Commande;
import com.example.cpp.repo.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;

    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepo.findById(id).get();
    }

    public void saveCommande(Commande commande) {
        commandeRepo.save(commande);
    }

    public void saveCommandes(List<Commande> commandes) {
        for (Commande commande : commandes) commandeRepo.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepo.deleteById(id);
    }

    // Autres méthodes de service personnalisées si nécessaire
}
