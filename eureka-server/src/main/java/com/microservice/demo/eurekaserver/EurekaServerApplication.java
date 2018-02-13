package com.microservice.demo.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Bruno Giannella de Melo
 * Classe responsável por inicializar o servidor Eureka através do Spring Boot
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
	/**
	 * Metódo responsável por inicializar o servidor
	 * @param args String[] - parâmetro que recebe os argumentos para o metódo main
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
