package com.microservice.demo.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Bruno Giannella de Melo
 * Metodo responsável por inicializar a instância do gateway Zuul da Netflix
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class ApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
}
