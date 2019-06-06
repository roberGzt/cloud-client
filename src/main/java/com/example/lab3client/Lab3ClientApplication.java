package com.example.lab3client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Lab3ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab3ClientApplication.class, args);
	}

}
