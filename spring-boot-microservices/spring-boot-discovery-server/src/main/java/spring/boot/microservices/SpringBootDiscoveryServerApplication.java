package spring.boot.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDiscoveryServerApplication.class, args);
	}

}
