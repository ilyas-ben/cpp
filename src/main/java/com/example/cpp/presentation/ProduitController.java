package com.example.cpp.presentation;

import com.example.cpp.model.Produit;
import com.example.cpp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }


    @PostMapping
    public void saveProduits(@RequestBody List<Produit> produits) {
        produitService.saveProduits(produits);
    }


    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }

    // Autres méthodes de contrôleur si nécessaire
}
