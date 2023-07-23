package com.quamtechs.Licences_WebFlux;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient; */
import org.springframework.web.reactive.function.client.WebClient;

import com.quamtechs.Licences_WebFlux.entities.Projet;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class LicencesWebFluxApplication {

	//private static final String SpringApplication = null;
	/*@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(LicencesWebFluxApplication.class, args);
		
		final String URL =  "http://127.0.0.1:8080/projet";
		//WebClient client =  
		WebClient client = WebClient.create(URL);

		Flux<Projet> listerTousLesProjet = client.get()
		.uri("/listerprojets")
		.retrieve()
		.bodyToFlux(Projet.class);
		//.blockFirst();
		listerTousLesProjet.subscribe(System.out::println);

		//System.out.println(listerTousLesProjet);

	}
	





}
