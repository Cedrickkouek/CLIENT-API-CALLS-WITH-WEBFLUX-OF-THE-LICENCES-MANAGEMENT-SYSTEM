package com.quamtechs.Licences_WebFlux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.quamtechs.Licences_WebFlux.entities.Projet;

@Repository
public interface ProjetRepository extends ReactiveMongoRepository<Projet, String> {
    
}
