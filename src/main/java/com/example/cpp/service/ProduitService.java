package com.example.cpp.service;

import com.example.cpp.model.Produit;
import com.example.cpp.repo.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    public List<Produit> getAllProduits() {
        return produitRepo.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepo.findById(id).get();
    }

    public void saveProduit(Produit produit) {
        produitRepo.save(produit);
    }
    public void saveProduits(List<Produit> produits) {
        for (Produit produit : produits) produitRepo.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepo.deleteById(id);
    }

    // Autres méthodes de service personnalisées si nécessaire
}
