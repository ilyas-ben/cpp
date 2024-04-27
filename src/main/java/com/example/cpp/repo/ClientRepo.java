package com.example.cpp.repo;


import com.example.cpp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Client c SET c.nom = :#{#client.nom}, c.adresse = :#{#client.adresse}, c.email = :#{#client.email}, c.telephone = :#{#client.telephone} WHERE c.id = :#{#client.id}")
    void updateClient(@Param("client") Client client);
}
