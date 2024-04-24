package com.example.cpp.repo;

import com.example.cpp.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo  extends JpaRepository<Produit,Long> {
}
