package edu.spring.boot.api.account.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootAccountManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAccountManagerApiApplication.class, args);
	}

}
