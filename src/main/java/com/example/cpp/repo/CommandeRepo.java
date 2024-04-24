package com.example.cpp.repo;

import com.example.cpp.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
