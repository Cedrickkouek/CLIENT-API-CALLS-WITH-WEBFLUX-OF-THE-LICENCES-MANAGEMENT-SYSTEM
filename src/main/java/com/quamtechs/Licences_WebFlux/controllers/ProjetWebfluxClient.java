package com.quamtechs.Licences_WebFlux.controllers;

//import org.apache.tomcat.util.http.parser.MediaType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.rest.webmvc.support.Projector;
import org.springframework.http.MediaType;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.quamtechs.Licences_WebFlux.entities.Projet;
import com.quamtechs.Licences_WebFlux.enumeration.StatusProjet;
import com.quamtechs.Licences_WebFlux.payloads.CreerProjetPayload;

//import lombok.val;
import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class ProjetWebfluxClient {
    
    
    final String URL =  "http://127.0.0.1:8100/Licences/projet";

    //@Autowired(required = false)
    WebClient webClient = WebClient.create(URL);

	//@GetMapping
    public Projet listerTousLesProjet()
    {
		Flux<Projet> valeurReponse =
	 webClient.get()
		.uri("/listerprojets").accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Projet.class);
		return valeurReponse.blockFirst();
    }

	//@GetMapping
    public Projet rechercherProjetIdProjet(String idProjet)
    {
		Mono<Projet> valeurReponse =
	    webClient.get()
		.uri("/rechercher/{idProjet}" + idProjet).accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();
    }

	//@PutMapping
    public Projet modifierProjet(String idProjet, CreerProjetPayload creerProjetPayload)
   {
	Mono<Projet> valeurReponse =
	webClient.put()
		.uri("/modifier/{idProjet}" + idProjet).accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(creerProjetPayload), CreerProjetPayload.class)
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();
    }

	//@GetMapping
    public Projet verificationProjet(String cleProjet)
   {
	Mono<Projet> valeurReponse =
	webClient.get()
		.uri("/verification/{cleProjet}" + cleProjet).accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();
    }

	//@PutMapping
    public Projet activerProjet(String idProjet)
   {
	Mono<Projet> valeurReponse =  
	 webClient.put()
		.uri("/activerProjet/{idProjet}" + idProjet).accept(MediaType.APPLICATION_JSON)
		.bodyValue(Mono.just(StatusProjet.ENCOURS))
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();
    }

	//@PostMapping
    public Projet creerProjet(CreerProjetPayload creerProjetPayload)
   {
	
	Mono<Projet> valeurReponse =
	webClient.post()
		.uri("/creerprojet").accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(creerProjetPayload), CreerProjetPayload.class)
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();

    }

	//@PutMapping
    public Projet desactiverProjet(String idProjet)
   {
	Mono<Projet> valeurReponse =
	 webClient.put()
		.uri("/desactiverProjet/{idProjet}" + idProjet).accept(MediaType.APPLICATION_JSON)
		.bodyValue(Mono.just(StatusProjet.TERMINER))
		.retrieve()
		.bodyToMono(Projet.class);
		return valeurReponse.block();
    }


}

