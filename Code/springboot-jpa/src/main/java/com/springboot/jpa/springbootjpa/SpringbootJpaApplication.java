package com.springboot.jpa.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}
}
