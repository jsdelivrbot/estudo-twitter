package br.com.brunogiannella.icase.itaucasetwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Bruno Giannella
 * Classe responsável por inicializar e subiro serviço do twitter
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class ItauCaseTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauCaseTwitterApplication.class, args);
	}
	
}
