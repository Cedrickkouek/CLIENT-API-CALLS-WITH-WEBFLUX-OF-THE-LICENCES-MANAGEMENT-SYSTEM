package com.quamtechs.Licences_WebFlux.payloads;
import org.springframework.format.annotation.NumberFormat;

import com.quamtechs.Licences_WebFlux.enumeration.StatusService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreerServicePayload {
   
    private String IdProjet;
    
    private String nomService;
    
    private String description;
    
    
    @NumberFormat
    private float prix;
    
    private StatusService statusService;
    
    private String URLLogo;
    
    private String responsable;
   
    
}
