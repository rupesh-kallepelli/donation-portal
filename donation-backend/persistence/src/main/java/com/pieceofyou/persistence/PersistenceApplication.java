package com.pieceofyou.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/persistence")})
@SpringBootApplication
public class PersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceApplication.class, args);
	}

}
