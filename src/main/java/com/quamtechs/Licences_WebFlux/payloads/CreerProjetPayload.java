package com.quamtechs.Licences_WebFlux.payloads;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import com.quamtechs.Licences_WebFlux.enumeration.StatusProjet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreerProjetPayload {

    private String nomProjet;

    private String description;
   
    private StatusProjet statusProjet;
    
    private String nomDirecteurProjet;

    @DateTimeFormat
    private LocalDate dateCreation;

    private String urlLOgo;

}
