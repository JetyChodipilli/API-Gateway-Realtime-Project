package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Msp08ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp08ProductServiceApplication.class, args);
	}

}
