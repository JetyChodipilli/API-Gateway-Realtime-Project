package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.jt.repo")  // Your repository package
@EntityScan(basePackages = "com.nt.entity") 
public class Msp08OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp08OrderServiceApplication.class, args);
	}

}
