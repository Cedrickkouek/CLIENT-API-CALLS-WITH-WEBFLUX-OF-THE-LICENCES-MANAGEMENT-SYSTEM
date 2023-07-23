package com.quamtechs.Licences_WebFlux.payloads;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
public class CreerLicencePayload {

    private String idService;
    
    private String idProjet;
    
    @DateTimeFormat
    private LocalDate dateAchat;
    
    private String idUtilisateur;
    
    private String nomUtilisateur;
    
    private String idPaiement;
   
}