package com.example.cpp.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<Produit> produits;

    private Date dateCommande;

    private double montantTotal;


    public Commande() {
    }

    public Commande(Long id, Client client, List<Produit> produits, Date dateCommande, double montantTotal) {
        this.id = id;
        this.client = client;
        this.produits = produits;
        this.dateCommande = dateCommande;
        this.montantTotal = montantTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", client=" + client +
                ", produits=" + produits +
                ", dateCommande=" + dateCommande +
                ", montantTotal=" + montantTotal +
                '}';
    }
}
